package systems.beep.exception;

/**
 * Exception thrown to indicate that an incorrect address has been provided.
 * <p>
 * This exception is a subclass of {@link RuntimeException} and is used to signal
 * errors related to invalid or improperly formatted addresses, particularly in
 * contexts where correct addressing is critical for communication or data handling.
 * </p>
 *
 * <p>
 * The {@code IncorrectAddressException} can be instantiated with or without a custom
 * error message, providing additional context when required.
 * </p>
 */
public class IncorrectAddressException extends RuntimeException {

    /**
     * Constructs a new {@code IncorrectAddressException} with no detail message.
     */
    public IncorrectAddressException() {
        super();
    }

    /**
     * Constructs a new {@code IncorrectAddressException} with the specified detail message.
     *
     * @param message the detail message that explains the reason for the exception.
     */
    public IncorrectAddressException(final String message) {
        super(message);
    }

}
