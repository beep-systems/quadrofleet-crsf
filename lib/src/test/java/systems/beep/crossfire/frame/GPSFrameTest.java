package systems.beep.crossfire.frame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import systems.beep.helper.FormatHelper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GPSFrameTest {

    private byte[] rawData;

    @BeforeEach
    void setUp() {
        rawData = FormatHelper.hexToByteArraySpaced("C8 11 02 00 00 00 00 00 00 00 00 00 00 00 00 03 E7 00 6E");
    }

    @Test
    void testGetFrameSize() {
        GPSFrame frame = new GPSFrame(rawData);
        assertEquals(19, frame.getFrameSize(), "Frame size should always be 19 bytes for GPSFrame");
    }

    @Test
    void testGetLatitude() {
        GPSFrame frame = new GPSFrame(rawData);
        double expectedLatitude = 0;
        assertEquals(expectedLatitude, frame.getLatitude(), 0.000001, "Latitude calculation is incorrect");
    }

    @Test
    void testGetLongitude() {
        GPSFrame frame = new GPSFrame(rawData);
        double expectedLongitude = 0;
        assertEquals(expectedLongitude, frame.getLongitude(), 0.000001, "Longitude calculation is incorrect");
    }

    @Test
    void testGetGroundSpeed() {
        GPSFrame frame = new GPSFrame(rawData);
        double expectedGroundSpeed = 0;
        assertEquals(expectedGroundSpeed, frame.getGroundSpeed(), 0.01, "Ground speed calculation is incorrect");
    }

    @Test
    void testGetHeading() {
        GPSFrame frame = new GPSFrame(rawData);
        double expectedHeading = 0;
        assertEquals(expectedHeading, frame.getHeading(), 0.01, "Heading calculation is incorrect");
    }

    @Test
    void testGetAltitude() {
        GPSFrame frame = new GPSFrame(rawData);
        int expectedAltitude = -1;
        assertEquals(expectedAltitude, frame.getAltitude(), "Altitude calculation is incorrect");
    }

    @Test
    void testGetSatellites() {
        GPSFrame frame = new GPSFrame(rawData);
        int expectedSatellites = 0;
        assertEquals(expectedSatellites, frame.getSatellites(), "Satellites count is incorrect");
    }

    @Test
    void testIsTelemetry() {
        GPSFrame frame = new GPSFrame(rawData);
        assertTrue(frame.isTelemetry(), "GPSFrame should always be telemetry");
    }

    @Test
    void testToString() {
        GPSFrame frame = new GPSFrame(rawData);
        String expectedString = String.format(
                "GPSFrame | Latitude: %.6f, Longitude: %.6f, Ground speed (m/s): %.2f, Heading (grad): %.2f, Altitude (m): %d, Satellites: %d",
                frame.getLatitude(), frame.getLongitude(), frame.getGroundSpeed(), frame.getHeading(), frame.getAltitude(), frame.getSatellites());

        assertEquals(expectedString, frame.toString(), "String representation of GPSFrame is incorrect");
    }

}
