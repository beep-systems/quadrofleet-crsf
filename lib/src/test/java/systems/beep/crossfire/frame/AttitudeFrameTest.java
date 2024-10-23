package systems.beep.crossfire.frame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import systems.beep.helper.FormatHelper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AttitudeFrameTest {

    private byte[] rawData;

    @BeforeEach
    void setUp() {
        rawData = FormatHelper.hexToByteArraySpaced("C8 08 1E 00 22 FF A9 3C 10 C4");
    }

    @Test
    void testGetFrameSize() {
        AttitudeFrame frame = new AttitudeFrame(rawData);
        assertEquals(10, frame.getFrameSize(), "Frame size should always be 10 bytes");
    }

    @Test
    void testGetPitch() {
        AttitudeFrame frame = new AttitudeFrame(rawData);
        float expectedPitch = (float) (((short) ((rawData[3] << 8) | (rawData[5] & 0xFF)) / 1000.0f) * CRSFFrame.DEGREES / 10);
        assertEquals(expectedPitch, frame.getPitch(), 0.001, "Pitch calculation is incorrect");
    }

    @Test
    void testGetRoll() {
        AttitudeFrame frame = new AttitudeFrame(rawData);
        float expectedRoll = (float) (((short) ((rawData[5] << 8) | (rawData[6] & 0xFF)) / 1000.0f) * CRSFFrame.DEGREES / 10);
        assertEquals(expectedRoll, frame.getRoll(), 0.001, "Roll calculation is incorrect");
    }

    @Test
    void testGetYaw() {
        AttitudeFrame frame = new AttitudeFrame(rawData);
        float expectedYaw = (float) (((short) ((rawData[7] << 8) | (rawData[8] & 0xFF)) / 1000.0f) * CRSFFrame.DEGREES / 10);
        assertEquals(expectedYaw, frame.getYaw(), 0.001, "Yaw calculation is incorrect");
    }

    @Test
    void testIsTelemetry() {
        AttitudeFrame frame = new AttitudeFrame(rawData);
        assertTrue(frame.isTelemetry(), "AttitudeFrame should always be telemetry");
    }

    @Test
    void testToString() {
        AttitudeFrame frame = new AttitudeFrame(rawData);
        String expectedString = "AttitudeFrame | Pitch: " + frame.getPitch() + ", Roll: " + frame.getRoll() + ", Yaw: " + frame.getYaw();
        assertEquals(expectedString, frame.toString(), "String representation is incorrect");
    }

}
