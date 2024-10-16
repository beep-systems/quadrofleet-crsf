package systems.beep.crossfire.frame;

import systems.beep.helper.TelemetryHelper;

import java.util.Arrays;

/**
 * Represents a CRSF (Crossfire) protocol frame for vertical speed telemetry data
 * with GPS-based variometers. This frame is used to provide vertical speed information
 * when the system does not include a barometer sensor. If a barometer is available,
 * the {@code CRSF_FRAMETYPE_BARO_ALTITUDE} frame type should be used instead to
 * include both altitude and vertical speed data.
 * <p>
 * The frame size is fixed at 9 bytes, and the data format includes altitude information
 * as well as vertical speed in centimeters per second.
 * </p>
 */
public class BarometerVariometerFrame extends CRSFFrame {

    /**
     * Constructs a {@code BarometerVariometerFrame} from the raw data received in a CRSF packet.
     *
     * @param rawData the raw byte array representing the frame data.
     */
    public BarometerVariometerFrame(final byte[] rawData) {
        super(rawData);
    }

    /**
     * Returns the size of the barometric variometer frame.
     * The frame size is fixed at 9 bytes.
     *
     * @return the size of the frame, which is always 9 bytes.
     */
    @Override
    public int getFrameSize() {
        return 9;
    }

    /**
     * Provides a string representation of the barometric variometer frame, including
     * altitude and vertical speed information.
     *
     * @return a string describing the frame with altitude and vertical speed.
     */
    @Override
    public String toString() {
        return "BarometerVariometerFrame |" +
                " Altitude: " + getAltitude() + " meters" +
                ", Vertical Speed: " + getVerticalSpeed() + " m/s";
    }

    /**
     * Returns the altitude measured by the GPS-based variometer.
     * The altitude value is extracted from the raw data bytes, starting from index 3.
     * The {@link TelemetryHelper#getBarometerAltitude(byte[])} method is used for parsing.
     *
     * @return the altitude in meters.
     */
    public float getAltitude() {
        return TelemetryHelper.getBarometerAltitude(Arrays.copyOfRange(rawData, 3, 5));
    }

    /**
     * Returns the vertical speed measured by the GPS-based variometer.
     * The vertical speed is provided in centimeters per second, and this method converts
     * it to meters per second by dividing by 100.
     * The raw data for vertical speed is extracted from indices 5 and 6.
     *
     * @return the vertical speed in meters per second.
     */
    public float getVerticalSpeed() {
        return ((short) ((rawData[5] << 8) | (rawData[6] & 0xFF))) / 100.0f;
    }

}
