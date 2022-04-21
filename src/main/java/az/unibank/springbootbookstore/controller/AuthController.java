package az.unibank.springbootbookstore.controller;

import az.unibank.springbootbookstore.dao.repository.AccountRepository;
import az.unibank.springbootbookstore.dto.request.SignupRequest;
import az.unibank.springbootbookstore.security.MyUserDetailsService;
import az.unibank.springbootbookstore.security.data.AuthenticationRequest;
import az.unibank.springbootbookstore.security.data.AuthenticationResponse;
import az.unibank.springbootbookstore.security.util.JwtUtil;
import az.unibank.springbootbookstore.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/auth")
public class AuthController {
    private final AuthenticationManager manager;

    private final AccountRepository repository;

    private final MyUserDetailsService userDetailsService;

    private final UserProfileService userProfileService;

    private final JwtUtil jwtUtil;

    @PostMapping(path = "/login",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public AuthenticationResponse login(@RequestBody AuthenticationRequest request){
        try {
            manager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        }catch (AuthenticationException exception){
            throw new UsernameNotFoundException("User Not Found!");
        }
        final String jwt = jwtUtil.generateToken(userDetailsService.loadUserByUsername(request.getUsername()));
        return new AuthenticationResponse(jwt);
    }

    @PostMapping(path = "/signup",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean signup(@RequestBody SignupRequest request){
        return userProfileService.addUser(request);
    }
}
