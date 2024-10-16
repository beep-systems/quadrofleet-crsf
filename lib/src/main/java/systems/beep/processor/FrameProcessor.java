package systems.beep.processor;

import systems.beep.crossfire.frame.CRSFFrame;
import systems.beep.exception.CorruptedPackageException;
import systems.beep.exception.IncorrectFrameTypeException;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * Processor for handling and processing CRSF (Crossfire) frames from incoming data.
 * <p>
 * The {@code FrameProcessor} class implements the {@link IFrameProcessor}
 * interface and provides methods to process byte data, build frames,
 * and maintain statistics regarding frame processing. It manages a buffer of incoming data
 * and processes it into complete CRSF frames, while tracking the number of successfully processed
 * frames and any errors encountered during the process.
 * </p>
 */
public class FrameProcessor implements IFrameProcessor {

    private final FrameBuffer frameBuffer = new FrameBuffer();

    private int frameProcessed = 0;

    private int errorProcessed = 0;

    /**
     * Processes incoming byte data and consumes the resulting frames.
     * <p>
     * This method analyzes the provided byte data, extracts CRSF frames, and passes
     * them to the provided {@code frameConsumer} for further processing. If a frame cannot be built,
     * the internal buffer is either fixed or flushed, and errors are tracked.
     * </p>
     *
     * @param data          the byte array containing raw frame data. Must not be null.
     * @param frameConsumer a consumer to process successfully built frames.
     */
    @Override
    public void processData(byte[] data, Consumer<CRSFFrame> frameConsumer) {
        frameBuffer.addData(data);

        while (frameBuffer.isFrameAvailable()) {
            buildFrame().ifPresent(frameConsumer);
        }
    }

    /**
     * Builds a CRSF frame from the frame buffer.
     * <p>
     * This method attempts to construct a CRSF frame from the buffer.
     * If the frame is successfully built, it is returned in an {@link Optional}.
     * Otherwise, errors are handled and the buffer is flushed or fixed.
     * </p>
     *
     * @return an Optional containing the built CRSF frame, or an empty Optional if frame building fails.
     */
    @Override
    public Optional<CRSFFrame> buildFrame() {
        try {
            CRSFFrame result = FrameFactory.generateFrame(frameBuffer.getFrame());

            frameProcessed++;

            return Optional.ofNullable(result);
        } catch (CorruptedPackageException | IncorrectFrameTypeException e) {
            errorProcessed++;

            frameBuffer.fixOrFlush();

            return Optional.empty();
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    /**
     * Flushes the frame buffer, clearing any stored data.
     */
    @Override
    public void flush() {
        frameBuffer.flush();
    }

    /**
     * Resets the frame processing statistics to zero.
     * <p>
     * This method resets both the count of successfully processed frames and the count
     * of error frames.
     * </p>
     */
    @Override
    public void resetStatistics() {
        frameProcessed = 0;
        errorProcessed = 0;
    }

    /**
     * Gets the count of successfully processed frames.
     *
     * @return the number of frames that have been successfully processed.
     */
    @Override
    public int getFrameProcessedCount() {
        return frameProcessed;
    }

    /**
     * Gets the count of error frames encountered during processing.
     *
     * @return the number of error frames that have been processed.
     */
    @Override
    public int getErrorFrameCount() {
        return errorProcessed;
    }

    /**
     * Calculates the error rate as a percentage of processed frames.
     * <p>
     * This method returns the percentage of error frames encountered relative to the total
     * number of frames processed.
     * </p>
     *
     * @return the error rate as a percentage.
     */
    @Override
    public int getErrorRate() {
        return frameProcessed == 0 ? 0 : (errorProcessed * 100 / frameProcessed);
    }

}
