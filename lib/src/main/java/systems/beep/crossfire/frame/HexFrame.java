package systems.beep.crossfire.frame;

import systems.beep.helper.FormatHelper;

/**
 * Represents a HexFrame in the CRSF protocol.
 * <p>
 * The HexFrame is used to encapsulate raw data in hexadecimal format, which can be useful for
 * debugging or logging purposes. It allows for visualizing the raw data in a human-readable
 * hexadecimal format, making it easier to inspect the content of the frame.
 * </p>
 *
 * @see CRSFFrame
 */
public class HexFrame extends CRSFFrame {

    /**
     * Constructs a HexFrame using the provided raw data.
     *
     * @param rawData the raw byte array representing the HexFrame.
     *                This data should follow the structure defined by the CRSF protocol.
     */
    public HexFrame(final byte[] rawData) {
        super(rawData);
    }

    /**
     * Provides a string representation of the HexFrame, displaying the raw data in hexadecimal format.
     *
     * @return a string summarizing the HexFrame details, including the hexadecimal representation of the data.
     */
    @Override
    public String toString() {
        return "HexFrame |" +
                " Data: " + FormatHelper.byteArrayToHexSpaced(rawData);
    }

    /**
     * Checks the CRC (Cyclic Redundancy Check) of the HexFrame.
     *
     * @return true if the CRC is valid; otherwise, false.
     * The current implementation assumes the CRC check is always valid.
     */
    @Override
    public boolean checkCRC() {
        return true;
    }

}
