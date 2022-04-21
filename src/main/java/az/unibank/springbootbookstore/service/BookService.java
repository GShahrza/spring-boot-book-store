package az.unibank.springbootbookstore.service;

import az.unibank.springbootbookstore.dto.response.BookDetailsResponse;
import az.unibank.springbootbookstore.dto.response.BookResponse;

import java.util.List;

public interface BookService {

    List<BookResponse> getAllBooks();

    List<BookDetailsResponse> getAllBooksWithAuthors();

    List<BookDetailsResponse> getAllBooksByAuthor(String firstName, String lastName);

    List<BookDetailsResponse> getAllBooksByRating(Double rating, Integer pageNo, Integer pageSize);
}
