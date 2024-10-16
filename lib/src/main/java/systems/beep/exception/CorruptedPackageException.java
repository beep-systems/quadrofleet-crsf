package systems.beep.exception;

/**
 * Exception thrown to indicate that a data package has been corrupted.
 * <p>
 * This exception is a subclass of {@link RuntimeException} and is used to signal errors
 * in processing data packages where the integrity cannot be guaranteed. It can be thrown
 * in scenarios where data corruption is detected, allowing the application to handle such
 * conditions appropriately.
 * </p>
 *
 * <p>
 * The {@code CorruptedPackageException} can be instantiated with or without a custom error message,
 * providing flexibility in error reporting.
 * </p>
 */
public class CorruptedPackageException extends RuntimeException {

    /**
     * Constructs a new {@code CorruptedPackageException} with no detail message.
     */
    public CorruptedPackageException() {
        super();
    }

    /**
     * Constructs a new {@code CorruptedPackageException} with the specified detail message.
     *
     * @param message the detail message that explains the reason for the exception.
     */
    public CorruptedPackageException(final String message) {
        super(message);
    }

}
