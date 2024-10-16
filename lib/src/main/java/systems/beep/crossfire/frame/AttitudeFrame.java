package systems.beep.crossfire.frame;

/**
 * Represents a CRSF (Crossfire) protocol frame for UAS (Unmanned Aerial System) attitude data.
 * The attitude frame provides information about the aircraft's orientation, including pitch, roll, and yaw angles.
 * This frame type is identified by the frame type code {@code 0x1E}, which corresponds to {@code CRSF_FRAMETYPE_ATTITUDE}.
 * <p>
 * For more details, refer to the
 * <a href="https://github.com/crsf-wg/crsf/wiki/CRSF_FRAMETYPE_ATTITUDE">CRSF Attitude Frame Wiki</a>.
 * </p>
 */
public class AttitudeFrame extends CRSFFrame {

    /**
     * Constructs an {@code AttitudeFrame} from the raw data received in a CRSF packet.
     *
     * @param rawData the raw byte array representing the frame data.
     */
    public AttitudeFrame(final byte[] rawData) {
        super(rawData);
    }

    /**
     * Returns the size of the attitude frame.
     * The frame size is fixed at 10 bytes.
     *
     * @return the size of the frame, which is always 10 bytes.
     */
    @Override
    public int getFrameSize() {
        return 10;
    }

    /**
     * Provides a string representation of the attitude frame, including pitch, roll, and yaw values.
     *
     * @return a string describing the frame with pitch, roll, and yaw angles.
     */
    @Override
    public String toString() {
        return "AttitudeFrame |" +
                " Pitch: " + getPitch() +
                ", Roll: " + getRoll() +
                ", Yaw: " + getYaw();
    }

    /**
     * Returns the pitch angle in radians, scaled down by a factor of 10,000.
     * The pitch value is derived from the raw data at indices 3 and 5.
     *
     * @return the pitch angle in radians/10000.
     */
    public float getPitch() {
        return (float) (((short) ((rawData[3] << 8) | (rawData[5] & 0xFF)) / 1000.0f) * DEGREES / 10);
    }

    /**
     * Returns the roll angle in radians, scaled down similarly to the pitch.
     * The roll value is derived from the raw data at indices 5 and 6.
     *
     * @return the roll angle in radians/10000.
     */
    public float getRoll() {
        return (float) (((short) ((rawData[5] << 8) | (rawData[6] & 0xFF)) / 1000.0f) * DEGREES / 10);
    }

    /**
     * Returns the yaw angle in radians, also scaled down by a factor of 10,000.
     * The yaw value is derived from the raw data at indices 7 and 8.
     *
     * @return the yaw angle in radians/10000.
     */
    public float getYaw() {
        return (float) (((short) ((rawData[7] << 8) | (rawData[8] & 0xFF)) / 1000.0f) * DEGREES / 10);
    }

    /**
     * Indicates that this frame is a telemetry frame.
     * Telemetry frames are used to send data from the aircraft to the ground station.
     *
     * @return {@code true}, indicating that this is a telemetry frame.
     */
    @Override
    public boolean isTelemetry() {
        return true;
    }

}