package systems.beep.exception;

/**
 * Exception thrown to indicate that an incorrect frame type has been encountered.
 * <p>
 * This exception is a subclass of {@link RuntimeException} and is used to signal errors
 * related to unsupported, unexpected, or invalid frame types in communication protocols.
 * It is typically thrown when the application encounters a frame type that it cannot process
 * or when the frame type does not conform to expected standards.
 * </p>
 *
 * <p>
 * The {@code IncorrectFrameTypeException} can be instantiated with or without
 * a custom error message to provide additional context regarding the frame type issue.
 * </p>
 */
public class IncorrectFrameTypeException extends RuntimeException {

    /**
     * Constructs a new {@code IncorrectFrameTypeException} with no detail message.
     */
    public IncorrectFrameTypeException() {
        super();
    }

    /**
     * Constructs a new {@code IncorrectFrameTypeException} with the specified detail message.
     *
     * @param message the detail message that explains the reason for the exception.
     */
    public IncorrectFrameTypeException(final String message) {
        super(message);
    }

}
