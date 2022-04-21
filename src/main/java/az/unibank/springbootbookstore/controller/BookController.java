package az.unibank.springbootbookstore.controller;

import az.unibank.springbootbookstore.dto.response.BookDetailsResponse;
import az.unibank.springbootbookstore.dto.response.BookResponse;
import az.unibank.springbootbookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/books")
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<BookResponse> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping(path = "/authors")
    public List<BookDetailsResponse> getAllBooksByAuthor(@RequestParam String firstName,
                                                         @RequestParam String lastName){
        return bookService.getAllBooksByAuthor(firstName,lastName);
    }

    @GetMapping(path = "/rating")
    public List<BookDetailsResponse> getAllBooksByRating(@RequestParam Double rating,
                                                         @RequestParam(defaultValue = "0") Integer pageNo,
                                                         @RequestParam(defaultValue = "10") Integer pageSize){
        return bookService.getAllBooksByRating(rating,pageNo,pageSize);
    }

    @GetMapping(path = "/details")
    public List<BookDetailsResponse> getAllBooksWithAuthors(){
        return bookService.getAllBooksWithAuthors();
    }

}
