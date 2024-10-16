package systems.beep.crossfire.frame;

/**
 * Represents a frame that communicates the current flight mode within the CRSF protocol.
 * <p>
 * The FlightModeFrame is responsible for extracting and representing the current flight mode
 * information from the raw data in a CRSF (Crossfire) frame. This allows for real-time monitoring
 * of an aircraft's flight status.
 * </p>
 *
 * <p>
 * The frame structure follows the CRSF protocol, where specific byte sequences define the flight mode.
 * </p>
 *
 * @see CRSFFrame
 */
public class FlightModeFrame extends CRSFFrame {

    /**
     * Constructs a FlightModeFrame using the provided raw data.
     *
     * @param rawData the raw byte array representing the flight mode frame.
     *                The data should conform to the expected structure defined by the CRSF protocol.
     *                It must contain enough bytes to extract the flight mode.
     */
    public FlightModeFrame(final byte[] rawData) {
        super(rawData);
    }

    /**
     * Provides a string representation of the FlightModeFrame.
     *
     * @return a string summarizing the frame details, including the current flight mode.
     * The output format is: "FlightModeFrame | Mode: [current_mode]".
     */
    @Override
    public String toString() {
        return "FlightModeFrame |" +
                " Mode: " + getMode();
    }

    /**
     * Extracts the flight mode from the raw data.
     *
     * @return the flight mode as a string.
     * @throws IllegalArgumentException if the raw data length is insufficient to extract the mode.
     *                                  The minimum required length is 4 bytes to ensure valid mode extraction.
     */
    public String getMode() {
        // Ensure that there is enough data to extract the mode
        if (rawData.length < 4) {
            throw new IllegalArgumentException("Insufficient raw data to extract mode.");
        }
        // Extract mode from rawData (starting from index 2 to the second last byte)
        return new String(rawData, 2, rawData.length - 4);
    }

    /**
     * Indicates whether this frame contains telemetry data.
     *
     * @return true, indicating that this frame contains telemetry data.
     * This is used to classify the frame type in the CRSF protocol.
     */
    @Override
    public boolean isTelemetry() {
        return true;
    }

}
