package systems.beep.crossfire.frame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import systems.beep.helper.FormatHelper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VariometerFrameTest {

    private byte[] rawData;

    @BeforeEach
    void setUp() {
        rawData = FormatHelper.hexToByteArraySpaced("C8 04 07 00 00 23");
    }

    @Test
    void testGetFrameSize() {
        VariometerFrame frame = new VariometerFrame(rawData);
        assertEquals(7, frame.getFrameSize(), "Frame size should always be 7 bytes for VariometerFrame");
    }

    @Test
    void testGetVerticalSpeed() {
        VariometerFrame frame = new VariometerFrame(rawData);
        short expectedSpeedValue = (short) ((rawData[3] & 0xFF) | ((rawData[4] & 0xFF) << 8));
        expectedSpeedValue = Short.reverseBytes(expectedSpeedValue);

        double expectedSpeed = expectedSpeedValue;
        assertEquals(expectedSpeed, frame.getVerticalSpeed(), 0.01, "Vertical speed calculation is incorrect");
    }

    @Test
    void testIsTelemetry() {
        VariometerFrame frame = new VariometerFrame(rawData);
        assertTrue(frame.isTelemetry(), "VariometerFrame should always be telemetry");
    }

    @Test
    void testToString() {
        VariometerFrame frame = new VariometerFrame(rawData);
        String expectedString = String.format("VariometerFrame | Vertical Speed: %.2f cm/s", frame.getVerticalSpeed());
        assertEquals(expectedString, frame.toString(), "String representation of VariometerFrame is incorrect");
    }

}
