package systems.beep.helper;

/**
 * A utility class for formatting and converting data types, specifically
 * for handling byte arrays and their hexadecimal representations.
 * This class provides methods to convert byte arrays to hexadecimal strings,
 * parse axis values, and convert boolean values to corresponding integer representations.
 * <p>
 * The {@code FormatHelper} class is designed to be used statically and does
 * not allow instantiation.
 * </p>
 */
public class FormatHelper {

    // Private constructor to prevent instantiation
    private FormatHelper() {
        // Prevents instantiation
    }

    /**
     * Converts a byte array to a hexadecimal string without spaces.
     *
     * @param data the byte array to be converted.
     * @return the hexadecimal string representation of the byte array.
     */
    public static String byteArrayToHex(byte[] data) {
        StringBuilder hexString = new StringBuilder();

        for (byte b : data) {
            hexString.append(String.format("%02X", b));
        }

        return hexString.toString().trim();
    }

    /**
     * Converts a byte array to a hexadecimal string with spaces between each byte.
     *
     * @param data the byte array to be converted.
     * @return the hexadecimal string representation of the byte array with spaces.
     */
    public static String byteArrayToHexSpaced(byte[] data) {
        StringBuilder hexString = new StringBuilder();

        for (byte b : data) {
            hexString.append(String.format("%02X ", b));
        }

        return hexString.toString().trim();
    }

    /**
     * Converts an integer array to a hexadecimal string with spaces between each byte.
     *
     * @param data the integer array to be converted.
     * @return the hexadecimal string representation of the integer array with spaces.
     */
    public static String byteArrayToHexSpaced(int[] data) {
        StringBuilder hexString = new StringBuilder();

        for (int b : data) {
            hexString.append(String.format("%02X ", (byte) b));
        }

        return hexString.toString().trim();
    }

    /**
     * Converts a hexadecimal string to a byte array.
     *
     * @param data the hexadecimal string to be converted.
     * @return the byte array representation of the hexadecimal string.
     */
    public static byte[] hexToByteArray(String data) {
        int len = data.length();
        byte[] result = new byte[len / 2];

        for (int i = 0; i < len; i += 2) {
            result[i / 2] = (byte) ((Character.digit(data.charAt(i), 16) << 4)
                    + Character.digit(data.charAt(i + 1), 16));
        }

        return result;
    }

    /**
     * Converts a spaced hexadecimal string to a byte array.
     *
     * @param data the spaced hexadecimal string to be converted.
     * @return the byte array representation of the spaced hexadecimal string.
     */
    public static byte[] hexToByteArraySpaced(String data) {
        int len = data.replace(" ", "").length();
        byte[] result = new byte[len / 2];

        for (int i = 0; i < len; i += 2) {
            result[i / 2] = (byte) ((Character.digit(data.replace(" ", "").charAt(i), 16) << 4)
                    + Character.digit(data.replace(" ", "").charAt(i + 1), 16));
        }

        return result;
    }

    /**
     * Parses a normalized axis value from a double to an integer representation.
     * <p>
     * The value is clamped between -1 and 1, and mapped to an integer value
     * where 0 represents the neutral state and positive/negative values represent
     * the direction and intensity of the axis.
     * </p>
     *
     * @param value the normalized axis value (between -1 and 1).
     * @return the corresponding integer representation.
     */
    public static int parseAxisValue(double value) {
        return (int) (TelemetryHelper.FAILSAFE_MICROSECONDS_VALUE + Math.max(-1, Math.min(1, value)) * 500);
    }

    /**
     * Parses a boolean value to an integer representation.
     * <p>
     * Converts {@code true} to the maximum microsecond value and {@code false}
     * to the failsafe value for use in telemetry control systems.
     * </p>
     *
     * @param value the boolean value to be parsed.
     * @return the corresponding integer representation.
     */
    public static int parseActivatedValue(boolean value) {
        return (value) ? TelemetryHelper.MAX_MICROSECONDS_VALUE : TelemetryHelper.FAILSAFE_CRSF_VALUE;
    }

}
