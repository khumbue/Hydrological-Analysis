package za.co.jobcreation.api.exception;

/**
 * Exception is thrown when an error is encountered when between mapping dtos and entities.
 *
 * @author khumbu
 */
public class MappingException extends RuntimeException {
    public MappingException(String message) {
        super(message);
    }
}
