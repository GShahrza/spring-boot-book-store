package az.unibank.springbootbookstore.controller;

import az.unibank.springbootbookstore.dto.request.AddBookRequest;
import az.unibank.springbootbookstore.dto.request.UpdateBookRequest;
import az.unibank.springbootbookstore.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserProfileService userService;

    @PostMapping(path = "/{id}")
    public Boolean addBook(@PathVariable Long id, @RequestBody AddBookRequest request){
        return userService.addBook(id,request);
    }

    @PutMapping(path = "/{id}")
    public Boolean updateBook(@PathVariable Long id, @RequestBody UpdateBookRequest request){
        return userService.updateBook(id,request);
    }
}
