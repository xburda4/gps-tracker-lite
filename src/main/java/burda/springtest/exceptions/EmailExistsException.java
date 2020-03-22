package burda.springtest.exceptions;

public class EmailExistsException extends Exception {

    public EmailExistsException() {
        super();
    }

    public EmailExistsException(String message) {
        super(message);
    }
}
