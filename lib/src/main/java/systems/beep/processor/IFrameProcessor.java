package systems.beep.processor;

import systems.beep.crossfire.frame.CRSFFrame;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * Interface for processing CRSF (Crossfire) frames from incoming byte data.
 * <p>
 * The {@code IFrameProcessor} interface defines methods for adding raw data,
 * building frames from that data, and maintaining statistics related to frame
 * processing. Implementing classes are expected to provide concrete implementations
 * for these methods.
 * </p>
 */
public interface IFrameProcessor {

    /**
     * Processes incoming byte data and consumes the resulting frames.
     * <p>
     * Implementing classes should analyze the provided byte array, extract complete CRSF frames,
     * and pass them to the provided {@code frameConsumer} for processing. This method is expected
     * to handle partial or fragmented frame data and only provide fully formed frames to the consumer.
     * </p>
     *
     * @param data          the byte array containing raw frame data. Must not be null.
     * @param frameConsumer a consumer to process successfully built frames.
     */
    void processData(byte[] data, Consumer<CRSFFrame> frameConsumer);

    /**
     * Builds a CRSF frame from the accumulated data.
     * <p>
     * This method attempts to construct a complete CRSF frame from the internal buffer.
     * If successful, it returns an {@link Optional} containing the built frame; otherwise,
     * it returns an empty {@link Optional}.
     * </p>
     *
     * @return an Optional containing the built CRSF frame, or an empty Optional if frame building fails.
     */
    Optional<CRSFFrame> buildFrame();

    /**
     * Flushes the internal buffer, clearing any stored data.
     * <p>
     * This method discards any data currently stored in the buffer, resetting the internal state
     * for new frame data.
     * </p>
     */
    void flush();

    /**
     * Resets the frame processing statistics to zero.
     * <p>
     * Implementing classes should reset the count of processed frames and error frames to zero,
     * clearing any historical statistics.
     * </p>
     */
    void resetStatistics();

    /**
     * Gets the count of successfully processed frames.
     * <p>
     * This method returns the total number of CRSF frames that have been successfully processed
     * without errors.
     * </p>
     *
     * @return the number of frames that have been successfully processed.
     */
    int getFrameProcessedCount();

    /**
     * Gets the count of error frames encountered during processing.
     * <p>
     * This method returns the total number of frames that have been encountered as errors
     * during processing.
     * </p>
     *
     * @return the number of error frames that have been processed.
     */
    int getErrorFrameCount();

    /**
     * Calculates the error rate as a percentage of processed frames.
     * <p>
     * This method calculates the ratio of error frames to the total number of frames processed
     * and returns it as a percentage.
     * </p>
     *
     * @return the error rate as a percentage.
     */
    int getErrorRate();

}
