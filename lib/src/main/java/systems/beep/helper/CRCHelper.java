package systems.beep.helper;

import java.util.Arrays;

/**
 * A utility class for calculating CRC (Cyclic Redundancy Check) values
 * using different polynomial values. This class provides methods to
 * compute CRC-8 checksums based on the BA and D5 polynomial standards.
 * <p>
 * The {@code CRCHelper} class is designed to be used statically and does
 * not allow instantiation. It provides two main methods for computing
 * CRC-8 checksums: {@link #BA(byte[], int, int)} and {@link #D5(byte[], int, int)}.
 * </p>
 */
public class CRCHelper {

    // BA polynomial used for CRC-8 calculation
    private static final byte[] BA_POLYNOMIAL = {(byte) 0xBA};

    // D5 polynomial used for CRC-8 calculation
    private static final byte[] D5_POLYNOMIAL = {(byte) 0xD5};

    // Private constructor to prevent instantiation
    private CRCHelper() {
        // Prevents instantiation
    }

    /**
     * Calculates the CRC-8 checksum using the BA polynomial for a specified range of data.
     *
     * @param data  the byte array containing the data to be checked.
     * @param start the starting index (inclusive) of the data range.
     * @param end   the ending index (exclusive) of the data range.
     * @return the CRC-8 checksum as a byte.
     * @throws IllegalArgumentException if the start or end index is out of bounds
     *                                  or if start is greater than or equal to end.
     */
    public static byte BA(byte[] data, int start, int end) {
        if (start < 0 || end > data.length || start >= end) {
            throw new IllegalArgumentException("Invalid range for CRC calculation.");
        }
        return crc8(Arrays.copyOfRange(data, start, end), BA_POLYNOMIAL);
    }

    /**
     * Calculates the CRC-8 checksum using the D5 polynomial for a specified range of data.
     *
     * @param data  the byte array containing the data to be checked.
     * @param start the starting index (inclusive) of the data range.
     * @param end   the ending index (exclusive) of the data range.
     * @return the CRC-8 checksum as a byte.
     * @throws IllegalArgumentException if the start or end index is out of bounds
     *                                  or if start is greater than or equal to end.
     */
    public static byte D5(byte[] data, int start, int end) {
        if (start < 0 || end > data.length || start >= end) {
            throw new IllegalArgumentException("Invalid range for CRC calculation.");
        }
        return crc8(Arrays.copyOfRange(data, start, end), D5_POLYNOMIAL);
    }

    /**
     * Computes the CRC-8 checksum for a given data array and polynomial.
     *
     * @param data       the byte array containing the data to be checked.
     * @param polynomial the polynomial to be used for the CRC calculation.
     * @return the CRC-8 checksum as a byte.
     */
    private static byte crc8(byte[] data, byte[] polynomial) {
        byte crc = 0;

        for (byte b : data) {
            crc ^= b;

            for (int i = 0; i < 8; i++) {
                if ((crc & 0x80) != 0) {
                    crc = (byte) ((crc << 1) ^ polynomial[0]);
                } else {
                    crc <<= 1;
                }
            }
        }

        return crc;
    }

}
