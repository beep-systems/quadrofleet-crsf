package systems.beep.helper;

import systems.beep.exception.IncorrectConversionException;

/**
 * A utility class for handling telemetry data related to unmanned aerial systems (UAS).
 * This class provides methods for converting between different formats, calculating
 * altitude from barometer data, and converting between CRSF (Crossfire) values and
 * their corresponding microseconds representation.
 * <p>
 * The {@code TelemetryHelper} class is designed to be used statically and does
 * not allow instantiation.
 * </p>
 */
public class TelemetryHelper {

    /**
     * The failsafe CRSF value.
     */
    public static final int FAILSAFE_CRSF_VALUE = 992;

    /**
     * The failsafe microseconds value.
     */
    public static final int FAILSAFE_MICROSECONDS_VALUE = 1500;

    /**
     * The maximum microseconds value.
     */
    public static final int MAX_MICROSECONDS_VALUE = 2000;

    /**
     * The slope used for conversion calculations.
     */
    private static final double SLOPE = 0.624;

    /**
     * The intercept used for conversion calculations.
     */
    private static final double INTERCEPT = 880.672;

    // Private constructor to prevent instantiation
    private TelemetryHelper() {
        // Prevents instantiation
    }

    /**
     * Calculates the altitude in meters from the given barometer data.
     *
     * @param data the byte array containing the barometer data.
     * @return the calculated altitude in meters.
     */
    public static float getBarometerAltitude(byte[] data) {
        int raw = ((data[0] & 0xFF) << 8) | (data[1] & 0xFF);

        // High bit is set, measurement is in meters
        if ((raw & 0x8000) == 0x8000) {
            raw = raw & 0x7FFF; // Remove the high bit
            raw *= 100; // Convert to centimeters
        } else {
            // Measurement is in decimeters + 10000dm
            raw -= 10000;
            raw *= 10;
        }

        return (float) raw / 10;
    }

    /**
     * Finds the first offset of a zero byte in the given byte array.
     *
     * @param data the byte array to search.
     * @return the index of the first zero bytes, or -1 if none is found.
     */
    public static int findOffset(byte[] data) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Converts a specified range of bytes in a byte array to an integer.
     *
     * @param data       the byte array containing the data.
     * @param startIndex the starting index for conversion.
     * @param endIndex   the ending index for conversion.
     * @return the converted integer value.
     */
    public static int binaryToInt(byte[] data, int startIndex, int endIndex) {
        int value = 0;

        for (int i = startIndex; i < endIndex; i++) {
            value |= (data[i] & 0xFF) << (8 * (endIndex - 1 - i));
        }

        return value;
    }

    /**
     * Converts a specified range of bytes in a byte array to a short.
     *
     * @param data       the byte array containing the data.
     * @param startIndex the starting index for conversion.
     * @param endIndex   the ending index for conversion.
     * @return the converted short value.
     */
    public static short binaryToShort(byte[] data, int startIndex, int endIndex) {
        short value = 0;

        for (int i = startIndex; i < endIndex; i++) {
            value = (short) ((value << 8) | (data[i] & 0xFF));
        }

        return value;
    }

    /**
     * Unpacks channel data from a byte array into an integer array.
     *
     * @param payload  the byte array containing the packed channel data.
     * @param channels the integer array to store the unpacked channel values.
     */
    public static void unpackChannels(byte[] payload, int[] channels) {
        final int numOfChannels = 16;
        final int srcBits = 11;
        final int inputChannelMask = (1 << srcBits) - 1;

        int bitsMerged = 0;
        int readValue = 0;
        int readByteIndex = 0;

        for (int n = 0; n < numOfChannels; n++) {
            while (bitsMerged < srcBits) {
                int readByte = payload[readByteIndex++] & 0xFF;
                readValue |= readByte << bitsMerged;
                bitsMerged += 8;
            }

            channels[n] = readValue & inputChannelMask;
            readValue >>= srcBits;
            bitsMerged -= srcBits;
        }
    }

    /**
     * Packs channel data from an integer array into a byte array.
     *
     * @param channels the integer array containing the channel values.
     * @param payload  the byte array to store the packed channel data.
     */
    public static void packChannels(int[] channels, byte[] payload) {
        final int numOfChannels = 16;
        final int srcBits = 11;
        final int outputChannelMask = (1 << srcBits) - 1;

        int bitsPacked = 0;
        int writeValue = 0;
        int writeByteIndex = 0;

        for (int n = 0; n < numOfChannels; n++) {
            writeValue |= (channels[n] & outputChannelMask) << bitsPacked;
            bitsPacked += srcBits;

            while (bitsPacked >= 8) {
                payload[writeByteIndex++] = (byte) (writeValue & 0xFF);
                writeValue >>= 8;
                bitsPacked -= 8;
            }
        }

        // Write any remaining bits
        if (bitsPacked > 0) {
            payload[writeByteIndex] = (byte) (writeValue & 0xFF);
        }
    }

    /**
     * Converts a CRSF value to its corresponding microseconds' representation.
     *
     * @param crsfValue the CRSF value to be converted.
     * @return the corresponding microseconds value.
     * @throws IncorrectConversionException if the CRSF value is out of range.
     */
    public static int convertCRSFToMicroseconds(int crsfValue) {
        if (crsfValue == FAILSAFE_CRSF_VALUE) {
            return FAILSAFE_MICROSECONDS_VALUE;
        }

        if (crsfValue < 0 || crsfValue > 1984) {
            throw new IncorrectConversionException("CRSF value must be between 0 and 1984.");
        }

        return (int) (SLOPE * crsfValue + INTERCEPT);
    }

    /**
     * Converts a microsecond value to its corresponding CRSF representation.
     *
     * @param microseconds the microsecond value to be converted.
     * @return the corresponding CRSF value.
     * @throws IncorrectConversionException if the converted CRSF value is out of range.
     */
    public static int convertMicrosecondsToCRSF(double microseconds) {
        if (microseconds == FAILSAFE_MICROSECONDS_VALUE) {
            return FAILSAFE_CRSF_VALUE;
        }

        int crsfValue = (int) Math.round((microseconds - INTERCEPT) / SLOPE);

        if (crsfValue < 0 || crsfValue > 1984) {
            throw new IncorrectConversionException("Converted CRSF value must be between 0 and 1984.");
        }

        return crsfValue;
    }

}
