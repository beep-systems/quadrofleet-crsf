package systems.beep.crossfire.frame;

import systems.beep.helper.TelemetryHelper;

/**
 * Represents a GPS position frame in the CRSF protocol.
 * <p>
 * This frame type corresponds to CRSF_FRAMETYPE_GPS (0x02), which transmits GPS position data.
 * It allows extracting key telemetry details like latitude, longitude, ground speed, heading, altitude,
 * and satellite count from the raw data. For more details, see the
 * <a href="https://github.com/crsf-wg/crsf/wiki/CRSF_FRAMETYPE_GPS">Wiki</a>.
 * </p>
 *
 * @see CRSFFrame
 */
public class GPSFrame extends CRSFFrame {

    /**
     * Constructs a GPSFrame using the provided raw data.
     *
     * @param rawData the raw byte array representing the GPS frame.
     *                The data should conform to the expected structure defined by the CRSF protocol.
     */
    public GPSFrame(final byte[] rawData) {
        super(rawData);
    }

    /**
     * Returns the size of the GPS frame in bytes.
     *
     * @return the fixed size of the GPS frame, which is 19 bytes.
     */
    @Override
    public int getFrameSize() {
        return 19; // The size of the GPS frame
    }

    /**
     * Provides a string representation of the GPSFrame.
     *
     * @return a string summarizing the frame details, including GPS parameters such as latitude, longitude,
     * ground speed, heading, altitude, and satellite count.
     */
    @Override
    public String toString() {
        return String.format("GPSFrame |" +
                        " Latitude: %.6f, Longitude: %.6f," +
                        " Ground speed (m/s): %.2f, Heading (grad): %.2f," +
                        " Altitude (m): %d, Satellites: %d",
                getLatitude(), getLongitude(), getGroundSpeed(),
                getHeading(), getAltitude(), getSatellites());
    }

    /**
     * Extracts the latitude from the raw data.
     *
     * @return the latitude in degrees, where the raw value is multiplied by 1e7 and stored in big-endian format.
     */
    public double getLatitude() {
        return (double) TelemetryHelper.binaryToInt(rawData, 3, 7) / 10_000_000;
    }

    /**
     * Extracts the longitude from the raw data.
     *
     * @return the longitude in degrees, where the raw value is multiplied by 1e7 and stored in big-endian format.
     */
    public double getLongitude() {
        return (double) TelemetryHelper.binaryToInt(rawData, 7, 11) / 10_000_000;
    }

    /**
     * Extracts the ground speed from the raw data.
     *
     * @return the ground speed in km/h, where the raw value is multiplied by 10 and stored in big-endian format.
     */
    public double getGroundSpeed() {
        return (double) TelemetryHelper.binaryToShort(rawData, 11, 13) / 100;
    }

    /**
     * Extracts the ground course or GPS heading from the raw data.
     *
     * @return the heading in degrees, where the raw value is multiplied by 100 and stored in big-endian format.
     */
    public double getHeading() {
        return (double) TelemetryHelper.binaryToShort(rawData, 13, 15) / 100;
    }

    /**
     * Extracts the altitude from the raw data.
     *
     * @return the GPS altitude in meters, adjusted by subtracting 1000 meters, with values stored in big-endian format.
     */
    public int getAltitude() {
        return (int) TelemetryHelper.binaryToShort(rawData, 15, 17) - 1000;
    }

    /**
     * Retrieves the number of satellites currently being tracked by the GPS.
     *
     * @return the count of satellites.
     */
    public int getSatellites() {
        return rawData[17];
    }

    /**
     * Indicates whether this frame contains telemetry data.
     *
     * @return true, indicating that this frame contains telemetry data as per the CRSF protocol.
     */
    @Override
    public boolean isTelemetry() {
        return true;
    }

}
