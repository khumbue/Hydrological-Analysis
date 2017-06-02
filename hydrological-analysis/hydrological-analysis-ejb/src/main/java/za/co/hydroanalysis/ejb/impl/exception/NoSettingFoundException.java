package za.co.jobcreation.ejb.impl.exception;

/**
 * Exception to indicate that no setting could be found, that matched the key
 * provided.
 *
 * @author khumbu
 */
public class NoSettingFoundException extends RuntimeException {
    private static final long serialVersionUID = -6744356915747736102L;

    public NoSettingFoundException(String key) {
        super(keyMessage(key));
    }

    private static String keyMessage(String key) {
        return "Setting Key [" + key + "]";
    }
}
