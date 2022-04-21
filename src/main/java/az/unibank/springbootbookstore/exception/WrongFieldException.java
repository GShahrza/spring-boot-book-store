package az.unibank.springbootbookstore.exception;

public class WrongFieldException extends RuntimeException{

    public WrongFieldException() {
    }

    public WrongFieldException(String message) {
        super(message);
    }
}
