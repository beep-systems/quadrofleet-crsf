package systems.beep.crossfire.frame;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Represents an OpenTx synchronization frame in the CRSF protocol.
 * <p>
 * The OpenTxSyncFrame corresponds to the CRSF_FRAMETYPE_OPENTX_SYNC (0x10) frame type, which is used
 * for synchronization in OpenTx applications. It allows synchronization of data rate and offset within
 * the CRSF protocol. For more details, see the
 * <a href="https://github.com/crsf-wg/crsf/wiki/CRSF_FRAMETYPE_RADIO_ID">Wiki</a>.
 * </p>
 *
 * @see CRSFExtendedFrame
 */
public class OpenTxSyncFrame extends CRSFExtendedFrame {

    /**
     * Constructs an OpenTxSyncFrame using the provided raw data.
     *
     * @param rawData the raw byte array representing the OpenTx synchronization frame.
     *                This data should conform to the structure defined by the CRSF protocol.
     * @throws IllegalArgumentException if the raw data length is insufficient.
     */
    public OpenTxSyncFrame(final byte[] rawData) {
        super(rawData);
        if (rawData.length < getFrameSize()) {
            throw new IllegalArgumentException("Invalid raw data length for OpenTxSyncFrame.");
        }
    }

    /**
     * Returns the size of the OpenTxSync frame.
     *
     * @return the size of the frame, which is eight bytes.
     */
    @Override
    public int getFrameSize() {
        return 8;
    }

    /**
     * Provides a string representation of the OpenTxSyncFrame,
     * summarizing the rate and offset values.
     *
     * @return a string summarizing the OpenTxSyncFrame details, including rate and offset.
     */
    @Override
    public String toString() {
        return "OpenTxSyncFrame |" +
                " Rate: " + getRate() + " or " + getRateInHz() + " Hz" +
                ", Offset: " + getOffset();
    }

    /**
     * Retrieves the rate in microseconds (1e-6 seconds).
     *
     * @return the rate value in microseconds.
     */
    public int getRate() {
        return ByteBuffer.wrap(getData(), 0, 4).order(ByteOrder.BIG_ENDIAN).getInt();
    }

    /**
     * Retrieves the rate in Hertz.
     *
     * @return the calculated frequency in Hertz.
     */
    public double getRateInHz() {
        return 1 / (getRate() / 10_000_000.0); // Calculate frequency in Hz
    }

    /**
     * Retrieves the offset in microseconds.
     *
     * @return the offset value in microseconds.
     */
    public int getOffset() {
        return ByteBuffer.wrap(getData(), 4, 4).order(ByteOrder.BIG_ENDIAN).getInt();
    }

}
