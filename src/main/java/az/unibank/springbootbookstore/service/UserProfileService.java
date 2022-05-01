package az.unibank.springbootbookstore.service;

import az.unibank.springbootbookstore.dto.request.AddBookRequest;
import az.unibank.springbootbookstore.dto.request.SignupRequest;
import az.unibank.springbootbookstore.dto.request.UpdateBookRequest;
import az.unibank.springbootbookstore.dto.response.UserProfileResponse;

import java.util.List;

public interface UserProfileService {
    Boolean addUser(SignupRequest request);

    Boolean addBook(Long username, AddBookRequest request);

    Boolean updateBook(Long id, UpdateBookRequest request);

    List<UserProfileResponse> getAll();

}
