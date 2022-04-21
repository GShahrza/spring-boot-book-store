package az.unibank.springbootbookstore.service.impl;

import az.unibank.springbootbookstore.dao.entity.Book;
import az.unibank.springbootbookstore.dao.entity.UserProfile;
import az.unibank.springbootbookstore.dao.repository.BookRepository;
import az.unibank.springbootbookstore.dao.repository.UserProfileRepository;
import az.unibank.springbootbookstore.dto.response.BookDetailsResponse;
import az.unibank.springbootbookstore.dto.response.BookResponse;
import az.unibank.springbootbookstore.dto.response.CategoryResponse;
import az.unibank.springbootbookstore.dto.response.UserProfileResponse;
import az.unibank.springbootbookstore.exception.UserNotFoundException;
import az.unibank.springbootbookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final UserProfileRepository userProfileRepository;

    @Override
    public List<BookResponse> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(book -> new BookResponse(book.getId(), book.getTittle(), book.getIsbn()
                        , book.getTotalPages(), book.getRating(),
                        book.getCategories().stream()
                                .map(category -> new CategoryResponse(category.getId(), category.getCategoryName()))
                                .collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDetailsResponse> getAllBooksWithAuthors() {
        return convertBookDTO(bookRepository.findAll());
    }

    @Override
    public List<BookDetailsResponse> getAllBooksByAuthor(String firstName, String lastName) {
        UserProfile author = userProfileRepository.findByFirstNameAndLastName(firstName, lastName)
                .orElseThrow(() -> new UserNotFoundException(String
                        .format("Author: %s %s not found!", firstName, lastName)));

        return getAllBooksWithAuthors().stream()
                .filter(bookDetailsResponse -> bookDetailsResponse.getAuthors().stream()
                        .anyMatch(userProfileResponse -> userProfileResponse.getId().equals(author.getId())))
                .collect(Collectors.toList());
        //        return getAllBooks().stream()
//                .filter(bookDetailsResponse -> {
//                    for (int i = 0; i < bookDetailsResponse.getAuthors().size(); i++) {
//                        if(bookDetailsResponse.getAuthors().get(i).getId().equals(author.getId())){
//                            return true;
//                        }
//                    }
//                    return false;
//                })
//                .collect(Collectors.toList());
    }

    @Override
    public List<BookDetailsResponse> getAllBooksByRating(Double rating, Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        return convertBookDTO(bookRepository.findAllByRating(rating, paging));
    }

    private List<BookDetailsResponse> convertBookDTO(List<Book> books) {
        return books.stream()
                .map(book -> new BookDetailsResponse(book.getId(), book.getTittle(), book.getIsbn()
                        , book.getTotalPages(), book.getRating(),
                        book.getCategories().stream()
                                .map(category -> new CategoryResponse(category.getId(), category.getCategoryName()))
                                .collect(Collectors.toList()),
                        book.getAuthors().stream()
                                .map(userProfile -> new UserProfileResponse(userProfile.getId(), userProfile.getFirstName(), userProfile.getLastName()))
                                .collect(Collectors.toList())))
                .collect(Collectors.toList());
    }
}
