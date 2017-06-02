package za.co.jobcreation.web.exceptions;

/**
 * <p>Application Exception.</p>
 */
public class ApplicationException extends Exception {

	private static final long serialVersionUID = -1063533138176513417L;

	public ApplicationException() {
        super();
    }

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationException(Throwable cause) {
        super(cause);
    }
}
