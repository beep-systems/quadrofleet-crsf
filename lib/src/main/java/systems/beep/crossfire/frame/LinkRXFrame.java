package systems.beep.crossfire.frame;

/**
 * Represents a LinkRX frame in the CRSF protocol.
 * <p>
 * The LinkRX frame is used to communicate the receiver's RSSI (Received Signal Strength Indicator) percent
 * and downlink power. It corresponds to the CRSF_FRAMETYPE_LINK_RX_ID (0x1C) frame type.
 * For more details, see the
 * <a href="https://github.com/crsf-wg/crsf/wiki/CRSF_FRAMETYPE_LINK_RX_ID">Wiki</a>.
 * </p>
 *
 * @see CRSFFrame
 */
public class LinkRXFrame extends CRSFFrame {

    /**
     * Constructs a LinkRXFrame using the provided raw data.
     *
     * @param rawData the raw byte array representing the LinkRX frame.
     *                This data should conform to the structure defined by the CRSF protocol.
     */
    public LinkRXFrame(final byte[] rawData) {
        super(rawData);
    }

    /**
     * Returns the size of the LinkRX frame.
     *
     * @return the size of the frame, which is nine bytes.
     */
    @Override
    public int getFrameSize() {
        return 9;
    }

    /**
     * Provides a string representation of the LinkRXFrame, displaying the RSSI and downlink power.
     *
     * @return a string summarizing the LinkRXFrame details, including the uplink RSSI and downlink power index.
     */
    @Override
    public String toString() {
        return "LinkRXFrame |" +
                " Uplink RSSI: " + getUplinkRSSI() + "%" +
                ", Downlink Power Index: " + getDownlinkPower();
    }

    /**
     * Retrieves the uplink RSSI (Received Signal Strength Indicator) percent.
     *
     * @return the uplink RSSI percent extracted from rawData[4].
     * @throws IllegalArgumentException if the raw data length is insufficient for RSSI retrieval.
     */
    public int getUplinkRSSI() {
        if (rawData.length < 5) {
            throw new IllegalArgumentException("Invalid raw data length for RSSI retrieval.");
        }
        return rawData[4];
    }

    /**
     * Retrieves the downlink power index.
     *
     * @return the downlink power index extracted from rawData[7].
     * @throws IllegalArgumentException if the raw data length is insufficient for downlink power retrieval.
     */
    public int getDownlinkPower() {
        if (rawData.length < 8) {
            throw new IllegalArgumentException("Invalid raw data length for downlink power retrieval.");
        }
        return rawData[7];
    }

    /**
     * Indicates that this frame contains telemetry data.
     *
     * @return true, indicating that this frame is telemetry.
     */
    @Override
    public boolean isTelemetry() {
        return true;
    }

}
