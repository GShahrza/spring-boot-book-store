package az.unibank.springbootbookstore.exception;

import org.springframework.dao.DuplicateKeyException;

public class DuplicateUsernameException extends DuplicateKeyException {
    public DuplicateUsernameException(String msg) {
        super(msg);
    }

    public DuplicateUsernameException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
