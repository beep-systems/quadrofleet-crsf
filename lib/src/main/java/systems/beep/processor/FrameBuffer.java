package systems.beep.processor;

import systems.beep.crossfire.frame.CRSFFrame;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * A buffer class that handles incoming data packets for CRSF (Crossfire) frames.
 * It provides methods to add data to the buffer, retrieve complete frames,
 * and manage the state of the buffer.
 * <p>
 * The {@code FrameBuffer} class maintains a dynamic buffer to store incoming
 * bytes and analyzes them to extract valid frames according to CRSF protocol
 * specifications.
 * </p>
 */
public class FrameBuffer {

    // Maximum buffer size calculated based on CRSF frame specifications
    private final int MAX_BUFFER_SIZE = CRSFFrame.FRAME_MAX_SIZE * 2 + 2;

    // Internal list to store bytes in the buffer
    private final List<Byte> buffer = new ArrayList<>();

    // Current frame size being processed
    private int currentFrameSize = 0;

    // Flag indicating whether a complete frame is available
    private boolean isFrameAvailable = false;

    /**
     * Adds an array of data bytes to the buffer.
     *
     * @param data the byte array to be added to the buffer.
     */
    public void addData(final byte[] data) {
        if (data == null) {
            return;
        }

        for (byte datum : data) {
            buffer.add(datum);
        }

        analyzeBuffer();
    }

    /**
     * Retrieves the current contents of the buffer as a byte array.
     *
     * @return the byte array containing all bytes in the buffer.
     */
    public byte[] getData() {
        byte[] result = new byte[buffer.size()];

        for (int i = 0; i < buffer.size(); i++) {
            result[i] = buffer.get(i);
        }

        return result;
    }

    /**
     * Attempts to fix the buffer if possible; otherwise, it clears the buffer.
     */
    public void fixOrFlush() {
        if (tryToFixBuffer()) {
            analyzeBuffer();
            return;
        }

        flush();
    }

    /**
     * Clears the buffer and resets frame size and availability status.
     */
    public void flush() {
        buffer.clear();
        currentFrameSize = 0;
        isFrameAvailable = false;
    }

    /**
     * Checks if a complete frame is available for retrieval.
     *
     * @return true if a frame is available; false otherwise.
     */
    public boolean isFrameAvailable() {
        return isFrameAvailable;
    }

    /**
     * Retrieves a complete frame from the buffer.
     *
     * @return a byte array representing the retrieved frame.
     * @throws IllegalStateException if no complete frame is available.
     */
    public byte[] getFrame() {
        if (currentFrameSize <= 0 || currentFrameSize > CRSFFrame.FRAME_MAX_SIZE || buffer.size() < currentFrameSize) {
            fixOrFlush();
        }

        byte[] result = new byte[currentFrameSize];

        for (int i = 0; i < currentFrameSize; i++) {
            result[i] = buffer.get(0);
            buffer.remove(0);
        }

        currentFrameSize = 0;

        analyzeBuffer();

        return result;
    }

    /**
     * Tries to fix the buffer by removing bytes until a valid frame start byte is found.
     *
     * @return true if a valid start byte (-22) is found; false otherwise.
     */
    private boolean tryToFixBuffer() {
        while (buffer.size() >= 2) {
            buffer.remove(0);

            if (buffer.get(0) == -22) {
                return true;
            }
        }

        return false;
    }

    /**
     * Analyzes the current buffer state and determines the size of the frame.
     */
    private void analyzeBuffer() {
        if (currentFrameSize <= 0 || currentFrameSize > CRSFFrame.FRAME_MAX_SIZE) {
            extractFrameSize().ifPresent(size -> currentFrameSize = size);
        }

        isFrameAvailable = (currentFrameSize > 0 && buffer.size() >= currentFrameSize) || buffer.size() >= MAX_BUFFER_SIZE;
    }

    /**
     * Extracts the size of the frame from the buffer.
     *
     * @return an Optional containing the calculated frame size, or an empty Optional if it cannot be determined.
     */
    private Optional<Byte> extractFrameSize() {
        if (buffer.size() < 3 || buffer.get(1) <= 0 || buffer.get(1) > CRSFFrame.FRAME_MAX_SIZE) {
            return Optional.empty();
        }

        return Optional.of((byte) (buffer.get(1) + 2));
    }

}
