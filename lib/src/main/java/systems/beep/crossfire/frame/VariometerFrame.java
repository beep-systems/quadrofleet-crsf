package systems.beep.crossfire.frame;

/**
 * Represents a frame that conveys vertical speed information in the CRSF protocol.
 * <p>
 * The VariometerFrame corresponds to the CRSF_FRAMETYPE_VARIO (0x07), which transmits
 * vertical speed data. This data is commonly used in telemetry to monitor the rate of climb or descent.
 * For more details, see the
 * <a href="https://github.com/crsf-wg/crsf/wiki/CRSF_FRAMETYPE_VARIO">Wiki</a>.
 * </p>
 *
 * @see CRSFFrame
 */
public class VariometerFrame extends CRSFFrame {

    /**
     * Constructs a VariometerFrame using the provided raw data.
     *
     * @param rawData the raw byte array representing the Variometer frame.
     *                This data should adhere to the structure defined by the CRSF protocol.
     */
    public VariometerFrame(final byte[] rawData) {
        super(rawData);
    }

    /**
     * Retrieves the size of the Variometer frame.
     *
     * @return the size of the frame, which is seven bytes.
     */
    @Override
    public int getFrameSize() {
        return 7;
    }

    /**
     * Provides a string representation of the VariometerFrame.
     *
     * @return an empty string since the representation is not yet implemented.
     */
    @Override
    public String toString() {
        return String.format("VariometerFrame |" +
                " Vertical Speed: %.2f cm/s", getVerticalSpeed());
    }

    /**
     * Retrieves the vertical speed from the raw data.
     *
     * @return the vertical speed in cm/s. For example, a speed of 1.5 m/s is represented as 150 cm/s.
     */
    public double getVerticalSpeed() {
        short value = (short) ((rawData[3] & 0xFF) | ((rawData[4] & 0xFF) << 8));
        return Short.reverseBytes(value);
    }

    /**
     * Indicates that the VariometerFrame carries telemetry data.
     *
     * @return true, indicating that this frame contains telemetry information.
     */
    @Override
    public boolean isTelemetry() {
        return true;
    }

}
