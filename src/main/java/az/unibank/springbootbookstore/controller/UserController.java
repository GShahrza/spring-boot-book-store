package az.unibank.springbootbookstore.controller;

import az.unibank.springbootbookstore.dto.request.AddBookRequest;
import az.unibank.springbootbookstore.dto.request.UpdateBookRequest;
import az.unibank.springbootbookstore.dto.response.UserProfileResponse;
import az.unibank.springbootbookstore.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserProfileService userService;

    @PostMapping(path = "/{id}")
    @PreAuthorize("hasRole('PUBLISHER')")
    public Boolean addBook(@PathVariable Long id, @RequestBody AddBookRequest request){
        return userService.addBook(id,request);
    }

    @PutMapping(path = "/{id}")
    @PreAuthorize("hasRole('PUBLISHER')")
    public Boolean updateBook(@PathVariable Long id, @RequestBody UpdateBookRequest request){
        return userService.updateBook(id,request);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserProfileResponse> getAll(){
        return userService.getAll();
    }
}
