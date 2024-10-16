package systems.beep.exception;

/**
 * Exception thrown to indicate that a conversion operation has failed.
 * <p>
 * This exception is a subclass of {@link RuntimeException} and is used to signal
 * errors arising from incorrect or invalid conversion attempts between data types
 * or formats. It is typically thrown when a conversion cannot be completed successfully,
 * such as when parsing incompatible data or performing invalid typecasting.
 * </p>
 *
 * <p>
 * The {@code IncorrectConversionException} can be instantiated with or without
 * a custom error message to provide additional context regarding the conversion failure.
 * </p>
 */
public class IncorrectConversionException extends RuntimeException {

    /**
     * Constructs a new {@code IncorrectConversionException} with no detail message.
     */
    public IncorrectConversionException() {
        super();
    }

    /**
     * Constructs a new {@code IncorrectConversionException} with the specified detail message.
     *
     * @param message the detail message that explains the reason for the exception.
     */
    public IncorrectConversionException(final String message) {
        super(message);
    }

}
