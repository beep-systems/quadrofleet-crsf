package systems.beep.crossfire.frame;

import systems.beep.crossfire.frame.sub.Address;
import systems.beep.crossfire.frame.sub.FrameType;
import systems.beep.exception.CorruptedPackageException;
import systems.beep.exception.IncorrectAddressException;
import systems.beep.exception.IncorrectFrameTypeException;
import systems.beep.helper.CRCHelper;

import java.util.Arrays;

/**
 * Represents a CRSF frame containing raw data and providing methods to
 * validate and access frame properties such as type, address, and data.
 */
public abstract class CRSFFrame {

    public static final byte FRAME_MAX_SIZE = 64; // Maximum size of the CRSF frame

    protected static final byte FRAME_SYNC_BYTE = (byte) 0xC8; // Synchronization byte for CRSF frames

    protected static final double DEGREES = 180.0 / Math.PI; // Conversion factor for radians to degrees

    protected final byte[] rawData; // Raw data of the frame

    /**
     * Constructs a CRSFFrame with the provided raw data.
     *
     * @param data the raw byte array representing the frame.
     * @throws CorruptedPackageException if the CRC check fails.
     */
    protected CRSFFrame(final byte[] data) throws CorruptedPackageException {
        this.rawData = data;

        if (!checkCRC()) {
            throw new CorruptedPackageException("CRC check failed");
        }
    }

    /**
     * Retrieves the frame type from the frame.
     *
     * @return the {@link FrameType} of the frame.
     * @throws IncorrectFrameTypeException if the frame type is invalid.
     */
    public FrameType getType() {
        return Arrays.stream(FrameType.values())
                .filter(item -> item.getValue() == rawData[2])
                .findAny()
                .orElseThrow(IncorrectFrameTypeException::new);
    }

    /**
     * Retrieves the address from the frame.
     *
     * @return the {@link Address} of the frame.
     * @throws IncorrectAddressException if the address is invalid.
     */
    public Address getAddress() {
        return Arrays.stream(Address.values())
                .filter(item -> item.getValue() == rawData[0])
                .findAny()
                .orElseThrow(IncorrectAddressException::new);
    }

    /**
     * Retrieves the raw data of the frame.
     *
     * @return the raw byte array of the frame.
     */
    public byte[] getRawData() {
        return rawData;
    }

    /**
     * Retrieves the data portion of the frame.
     *
     * @return a byte array containing the data from the frame.
     */
    public byte[] getData() {
        return Arrays.copyOfRange(rawData, 2, rawData.length);
    }

    /**
     * Checks the CRC of the frame to ensure data integrity.
     *
     * @return true if the CRC is valid, false otherwise.
     */
    public boolean checkCRC() {
        return CRCHelper.D5(rawData, 2, rawData.length - 1) == rawData[rawData.length - 1];
    }

    /**
     * Retrieves the size of the frame.
     *
     * @return the size of the frame in bytes.
     */
    public int getFrameSize() {
        return rawData.length;
    }

    /**
     * Provides a string representation of the frame.
     *
     * @return a string representation of the frame.
     */
    public abstract String toString();

    /**
     * Determines if the frame contains telemetry data.
     *
     * @return true if the frame contains telemetry data, false otherwise.
     */
    public boolean isTelemetry() {
        return false;
    }

}
