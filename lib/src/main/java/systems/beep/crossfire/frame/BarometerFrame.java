package systems.beep.crossfire.frame;

import systems.beep.helper.TelemetryHelper;

import java.util.Arrays;

/**
 * Represents a CRSF (Crossfire) protocol frame for barometric altitude data.
 * The barometric altitude frame provides information about the aircraft's altitude
 * as measured by a barometric sensor. This frame type is identified by the frame
 * type code {@code 0x09}, which corresponds to {@code CRSF_FRAMETYPE_BARO_ALTITUDE}.
 * <p>
 * For more information, refer to the
 * <a href="https://github.com/crsf-wg/crsf/wiki/CRSF_FRAMETYPE_BARO_ALTITUDE">CRSF Barometric Altitude Wiki</a>.
 * </p>
 */
public class BarometerFrame extends CRSFFrame {

    /**
     * Constructs a {@code BarometerFrame} from the raw data received in a CRSF packet.
     *
     * @param rawData the raw byte array representing the frame data.
     */
    public BarometerFrame(final byte[] rawData) {
        super(rawData);
    }

    /**
     * Returns the size of the barometric altitude frame.
     * The frame size is fixed at 7 bytes.
     *
     * @return the size of the frame, which is always 7 bytes.
     */
    @Override
    public int getFrameSize() {
        return 7;
    }

    /**
     * Provides a string representation of the barometer frame, including the altitude value.
     * This representation can be used for logging or debugging purposes.
     *
     * @return a string describing the frame with altitude information.
     */
    @Override
    public String toString() {
        return "BarometerFrame |" +
                " Altitude: " + getAltitude() + " meters";
    }

    /**
     * Returns the altitude measured by the barometric sensor.
     * The altitude value is extracted from the raw data bytes, starting from index 3.
     * The {@link TelemetryHelper#getBarometerAltitude(byte[])} method is used for parsing.
     *
     * @return the altitude in meters.
     */
    public float getAltitude() {
        return TelemetryHelper.getBarometerAltitude(Arrays.copyOfRange(rawData, 3, 5));
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
