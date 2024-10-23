package systems.beep.crossfire.frame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import systems.beep.helper.FormatHelper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FlightModeFrameTest {

    private byte[] validRawData;

    private byte[] insufficientRawData;

    @BeforeEach
    void setUp() {
        validRawData = FormatHelper.hexToByteArraySpaced("C8 07 21 57 41 49 54 00 AD");

        // Example of insufficient raw data, less than 4 bytes
        insufficientRawData = new byte[]{0x00, 0x01};
    }

    @Test
    void testGetModeValidData() {
        FlightModeFrame frame = new FlightModeFrame(validRawData);
        String expectedMode = "!WAIT";
        assertEquals(expectedMode, frame.getMode(), "Flight mode extraction is incorrect");
    }

    @Test
    void testWrongCRCException() {
        assertThrows(IllegalArgumentException.class, () -> new FlightModeFrame(insufficientRawData),
                "Should throw IllegalArgumentException when data is insufficient");
    }

    @Test
    void testIsTelemetry() {
        FlightModeFrame frame = new FlightModeFrame(validRawData);
        assertTrue(frame.isTelemetry(), "FlightModeFrame should always be telemetry");
    }

    @Test
    void testToString() {
        FlightModeFrame frame = new FlightModeFrame(validRawData);
        String expectedString = "FlightModeFrame | Mode: !WAIT";
        assertEquals(expectedString, frame.toString(), "String representation of FlightModeFrame is incorrect");
    }

}
