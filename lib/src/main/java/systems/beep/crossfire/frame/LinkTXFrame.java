package systems.beep.crossfire.frame;

/**
 * Represents a LinkTX frame in the CRSF protocol.
 * <p>
 * The LinkTX frame provides information about the transmitter's RSSI (Received Signal Strength Indicator) percent,
 * RF power, and packet rate (frames per second). It corresponds to the CRSF_FRAMETYPE_LINK_TX_ID (0x1D).
 * For more details, see the
 * <a href="https://github.com/crsf-wg/crsf/wiki/CRSF_FRAMETYPE_LINK_TX_ID">Wiki</a>.
 * </p>
 *
 * @see CRSFFrame
 */
public class LinkTXFrame extends CRSFFrame {

    /**
     * Constructs a LinkTXFrame using the provided raw data.
     *
     * @param rawData the raw byte array representing the LinkTX frame.
     *                This data should conform to the structure defined by the CRSF protocol.
     * @throws IllegalArgumentException if the raw data length is insufficient.
     */
    public LinkTXFrame(final byte[] rawData) {
        super(rawData);
        if (rawData.length < getFrameSize()) {
            throw new IllegalArgumentException("Invalid raw data length.");
        }
    }

    /**
     * Returns the size of the LinkTX frame.
     *
     * @return the size of the frame, which is 10 bytes.
     */
    @Override
    public int getFrameSize() {
        return 10;
    }

    /**
     * Provides a string representation of the LinkTXFrame,
     * summarizing the downlink RSSI, uplink power, and uplink FPS.
     *
     * @return a string summarizing the LinkTXFrame details, including downlink RSSI, uplink power, and uplink FPS.
     */
    @Override
    public String toString() {
        return "LinkTXFrame | " +
                "Downlink RSSI: " + getDownloadRSSI() + "%" +
                ", Uplink Power: " + getUplinkPower() +
                ", Uplink FPS: " + getUplinkFPS();
    }

    /**
     * Retrieves the RSSI percentage for the downlink.
     *
     * @return the downlink RSSI as a percentage.
     */
    public int getDownloadRSSI() {
        return rawData[4];
    }

    /**
     * Retrieves the RF power index for the uplink.
     *
     * @return the uplink RF power index.
     */
    public int getUplinkPower() {
        return rawData[7];  // Consider using an enum to represent possible values
    }

    /**
     * Retrieves the packet rate in frames per second (FPS).
     * The actual FPS can be calculated as value divided by 10.
     *
     * @return the uplink packet rate in FPS.
     */
    public int getUplinkFPS() {
        return rawData[8];  // Value represents FPS / 10
    }

    /**
     * Indicates whether this frame contains telemetry data.
     *
     * @return true, indicating that this frame contains telemetry data.
     */
    @Override
    public boolean isTelemetry() {
        return true;
    }

}
