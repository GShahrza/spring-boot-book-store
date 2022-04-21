package az.unibank.springbootbookstore.service.impl;

import az.unibank.springbootbookstore.dao.entity.*;
import az.unibank.springbootbookstore.dao.repository.AccountRepository;
import az.unibank.springbootbookstore.dao.repository.BookRepository;
import az.unibank.springbootbookstore.dao.repository.CategoryRepository;
import az.unibank.springbootbookstore.dao.repository.UserProfileRepository;
import az.unibank.springbootbookstore.dto.request.AddBookRequest;
import az.unibank.springbootbookstore.dto.request.SignupRequest;
import az.unibank.springbootbookstore.dto.request.UpdateBookRequest;
import az.unibank.springbootbookstore.exception.DuplicateUsernameException;
import az.unibank.springbootbookstore.exception.UserNotFoundException;
import az.unibank.springbootbookstore.service.UserProfileService;
import az.unibank.springbootbookstore.util.Validation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {

    private final PasswordEncoder encoder;

    private final AccountRepository accountRepository;

    private final BookRepository bookRepository;

    private final CategoryRepository categoryRepository;

    private final UserProfileRepository userRepository;

    @Override
    public Boolean addUser(SignupRequest request) {
        Validation.validateRequest(request);
        isExistsUsername(request.getUsername());
        isExistsEmail(request.getEmail());

        Account account = Account.builder()
                .email(request.getEmail())
                .username(request.getUsername())
                .password(encoder.encode(request.getPassword()))
                .build();
        account.getRoles().add(Role.builder()
                .id(2L)
                .roleName(ERole.ROLE_USER)
                .build());
        UserProfile userProfile = UserProfile.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastname())
                .account(account)
                .build();
        accountRepository.save(account);
        userRepository.save(userProfile);
        return true;
    }

    @Override
    public Boolean addBook(Long id, AddBookRequest request) {
        UserProfile userProfile = getUserById(id);
        Set<Category> categories = request.getCategories().stream()
                .map(categoryRequest -> categoryRepository.findById(categoryRequest.getId())
                        .orElseThrow(() -> new NoSuchElementException("Category Not Found!")))
                .collect(Collectors.toSet());
        Book book = Book.builder()
                .isbn(request.getIsbn())
                .tittle(request.getTittle())
                .rating(request.getRating())
                .totalPages(request.getTotalPages())
                .categories(categories)
                .build();
        userProfile.getBooks().add(bookRepository.save(book));
        userRepository.save(userProfile);
        return true;
    }

    @Override
    public Boolean updateBook(Long id, UpdateBookRequest request) {
        UserProfile userProfile = getUserById(id);
        Set<Category> categories = request.getCategories().stream()
                .map(categoryRequest -> categoryRepository.findById(categoryRequest.getId())
                        .orElseThrow(() -> new NoSuchElementException("Category Not Found!")))
                .collect(Collectors.toSet());
        Book book = bookRepository.findById(request.getId()).orElseThrow(() ->
                new NoSuchElementException("Book Not Found!"));
        book = Book.builder()
                .id(request.getId())
                .isbn(request.getIsbn())
                .totalPages(request.getTotalPages())
                .tittle(request.getTittle())
                .rating(request.getRating())
                .categories(categories)
                .build();
        userProfile.getBooks().add(bookRepository.save(book));
        userRepository.save(userProfile);
        return true;
    }

    private UserProfile getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("Author Not Found!"));
    }

    private void isExistsUsername(String username) {
        if (accountRepository.existsByUsername(username)) {
            throw new DuplicateUsernameException(String.format("Username: %s is already exists", username));
        }
    }

    private void isExistsEmail(String email) {
        if (accountRepository.existsByEmail(email)) {
            throw new DuplicateUsernameException(String.format("Email: %s is already exists", email));
        }
    }
}
