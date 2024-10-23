package systems.beep.crossfire.frame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import systems.beep.helper.FormatHelper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BatteryFrameTest {

    private byte[] validRawData;

    @BeforeEach
    void setUp() {
        validRawData = FormatHelper.hexToByteArraySpaced("C8 0A 08 00 00 00 02 00 00 23 00 7C");
    }

    @Test
    void testGetFrameSize() {
        BatteryFrame frame = new BatteryFrame(validRawData);
        assertEquals(12, frame.getFrameSize(), "Frame size should always be 12 bytes for BatteryFrame");
    }

    @Test
    void testGetVoltage() {
        BatteryFrame frame = new BatteryFrame(validRawData);
        double expectedVoltage = Short.reverseBytes((short) ((validRawData[3] & 0xFF) | (validRawData[4] << 8))) / 10.0;
        assertEquals(expectedVoltage, frame.getVoltage(), 0.01, "Voltage calculation is incorrect");
    }

    @Test
    void testGetCurrent() {
        BatteryFrame frame = new BatteryFrame(validRawData);
        double expectedCurrent = Short.reverseBytes((short) ((validRawData[5] & 0xFF) | (validRawData[6] << 8))) / 10.0;
        assertEquals(expectedCurrent, frame.getCurrent(), 0.01, "Current calculation is incorrect");
    }

    @Test
    void testGetFuel() {
        BatteryFrame frame = new BatteryFrame(validRawData);
        double expectedFuel = 35;
        assertEquals(expectedFuel, frame.getFuel(), "Fuel calculation is incorrect");
    }

    @Test
    void testGetRemaining() {
        BatteryFrame frame = new BatteryFrame(validRawData);
        float expectedRemaining = 0;
        assertEquals(expectedRemaining, frame.getRemaining(), "Remaining percentage is incorrect");
    }

    @Test
    void testIsTelemetry() {
        BatteryFrame frame = new BatteryFrame(validRawData);
        assertTrue(frame.isTelemetry(), "BatteryFrame should always be telemetry");
    }

    @Test
    void testToString() {
        BatteryFrame frame = new BatteryFrame(validRawData);
        String expectedString = "BatteryFrame |" +
                " Voltage (V): " + frame.getVoltage() +
                ", Current (A): " + frame.getCurrent() +
                ", Used capacity - fuel (mAh): " + frame.getFuel() +
                ", Remaining (%): " + frame.getRemaining();
        assertEquals(expectedString, frame.toString(), "String representation of BatteryFrame is incorrect");
    }

}
