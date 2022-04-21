package az.unibank.springbootbookstore.util;

import az.unibank.springbootbookstore.dto.request.SignupRequest;
import az.unibank.springbootbookstore.exception.FieldNullPointerException;
import az.unibank.springbootbookstore.exception.WrongFieldException;

public class Validation {

    public static void validateRequest(SignupRequest request) {
        validateFirstName(request.getFirstName());

        validateLastName(request.getLastname());

        validateUsername(request.getUsername());

        validateEmail(request.getEmail());

        validatePassword(request.getPassword());

    }

    private static void validatePassword(String password) {
        if (!password.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$*%^&+=])(?=\\S+$).{8,20}$")) {
            throw new WrongFieldException("Password:\nIt contains at least 8 characters and at most 20 characters.\n"
                    .concat("It contains at least one digit.\n")
                    .concat("It contains at least one upper case alphabet.\n")
                    .concat("It contains at least one lower case alphabet.\n")
                    .concat("It contains at least one special character which includes !@#$%&*()-+=^.\n")
                    .concat("It doesn't contain any white space."));
        }
    }

    private static void validateFirstName(String firstName) {
        isNull(firstName);
        if (firstName.length() < 3 || firstName.length() > 15) {
            throw new WrongFieldException
                    ("the length of the name must be greater than 3 letters and less than 15 letters.");
        }
    }

    private static void validateLastName(String lastName) {
        isNull(lastName);
        if (lastName.length() < 6 || lastName.length() > 20) {
            throw new WrongFieldException
                    ("the length of the surname must be greater than 6 letters and less than 20 letters.");
        }
    }

    private static void validateUsername(String username) {
        if (!username.matches("^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z\\d._]+(?<![_.])$")) {
            throw new WrongFieldException("Username:\nIt contains at least 8 characters and at most 20 characters.\n"
                    .concat("It contains at least one digit.\n")
                    .concat("It doesn't contain any white space.\n")
                    .concat("no _ or . at the beginning\n")
                    .concat("no _ or . at the end\n")
                    .concat("no __ or _. or ._ or .. inside"));
        }
    }

    private static void validateEmail(String email) {
        if (!email.matches("(?:[a-z\\d!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z\\d!#$%&'*+/=?^_`{|}~-]+)*|\"(?:" +
                "[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])" +
                "*\")@(?:(?:[a-z\\d](?:[a-z\\d-]*[a-z\\d])?\\.)+[a-z\\d](?:[a-z\\d-]*[a-z\\d])?|\\[(?:(2(5[0-5]|[0-" +
                "4]\\d)|1\\d\\d|[1-9]?\\d)\\.){3}(?:(2(5[0-5]|[0-4]\\d)|1\\d\\d|[1-9]?\\d)|" +
                "[a-z\\d-]*[a-z\\d]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b" +
                "\\x0c\\x0e-\\x7f])+)])")) {
            throw new WrongFieldException("Wrong email!");
        }
    }

    private static void isNull(String element) {
        if (element == null || element.trim().isEmpty()) {
            String message = String.format("Field cannot be null: %s", element);
            throw new FieldNullPointerException(message);
        }
    }

}
