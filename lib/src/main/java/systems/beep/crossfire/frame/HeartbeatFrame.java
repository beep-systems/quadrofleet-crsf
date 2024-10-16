package systems.beep.crossfire.frame;

/**
 * Represents a Heartbeat frame in the CRSF protocol.
 * <p>
 * This frame type corresponds to CRSF_FRAMETYPE_HEARTBEAT (0x0B), which is used to indicate
 * that a device is active and communicating. Heartbeat frames are regularly sent by devices
 * to signal their presence on the network.
 * For more details, see the
 * <a href="https://github.com/crsf-wg/crsf/wiki/CRSF_FRAMETYPE_HEARTBEAT">Wiki</a>.
 * </p>
 *
 * @see CRSFFrame
 */
public class HeartbeatFrame extends CRSFFrame {

    /**
     * Constructs a HeartbeatFrame using the provided raw data.
     *
     * @param rawData the raw byte array representing the Heartbeat frame.
     *                The data should conform to the expected structure defined by the CRSF protocol.
     */
    public HeartbeatFrame(final byte[] rawData) {
        super(rawData);
    }

    /**
     * Provides a string representation of the HeartbeatFrame.
     *
     * @return a string summarizing the frame details, including the origin device address.
     */
    @Override
    public String toString() {
        return "HeartbeatFrame |" +
                " Origin Device Address: " + getOriginDeviceAddress();
    }

    /**
     * Extracts the origin device address from the raw data.
     *
     * @return the origin device address extracted from the raw data.
     * The address is assumed to be stored at a specific index in the raw data array.
     */
    public int getOriginDeviceAddress() {
        // Assuming the origin device address is stored at a specific index in the rawData
        return rawData[3]; // Adjust the index based on the actual protocol specification
    }

    /**
     * Indicates whether this frame contains telemetry data.
     *
     * @return false, indicating that Heartbeat frames typically do not carry telemetry data.
     */
    @Override
    public boolean isTelemetry() {
        return false; // Heartbeat frames typically do not carry telemetry data
    }

}
