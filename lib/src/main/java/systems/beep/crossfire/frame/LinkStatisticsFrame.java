package systems.beep.crossfire.frame;

import systems.beep.crossfire.frame.sub.Address;
import systems.beep.crossfire.frame.sub.FrameType;
import systems.beep.helper.CRCHelper;

/**
 * Represents a LinkStatistics frame in the CRSF protocol.
 * <p>
 * The LinkStatistics frame provides signal-related information, including RSSI (Received Signal Strength Indicator),
 * SNR (Signal-to-Noise Ratio), link quality, RF mode, and transmit power. It corresponds to
 * CRSF_FRAMETYPE_LINK_STATISTICS (0x14). For more details, see the
 * <a href="https://github.com/crsf-wg/crsf/wiki/CRSF_FRAMETYPE_LINK_STATISTICS">Wiki</a>.
 * </p>
 *
 * @see CRSFFrame
 */
public class LinkStatisticsFrame extends CRSFFrame {

    /**
     * Constructs a LinkStatisticsFrame using the provided raw data.
     *
     * @param rawData the raw byte array representing the LinkStatistics frame.
     *                This data should conform to the structure defined by the CRSF protocol.
     * @throws IllegalArgumentException if the raw data length is insufficient.
     */
    public LinkStatisticsFrame(final byte[] rawData) {
        super(rawData);
        if (rawData.length < getFrameSize()) {
            throw new IllegalArgumentException("Invalid raw data length.");
        }
    }

    /**
     * Creates a builder for constructing a LinkStatisticsFrame.
     *
     * @return a new instance of the LinkStatisticsBuilder.
     */
    public static LinkStatisticsBuilder builder() {
        return new LinkStatisticsBuilder();
    }

    /**
     * Returns the size of the LinkStatistics frame.
     *
     * @return the size of the frame, which is 14 bytes.
     */
    @Override
    public int getFrameSize() {
        return 14;
    }

    /**
     * Provides a string representation of the LinkStatisticsFrame, summarizing the uplink and downlink statistics.
     *
     * @return a string summarizing the LinkStatisticsFrame details, including RSSI, SNR, link quality, and other telemetry data.
     */
    @Override
    public String toString() {
        return "LinkStatisticsFrame | " +
                "Uplink RSSI Ant. 1: " + getUplinkRSSI1() + " dBm" +
                ", Uplink RSSI Ant. 2: " + getUplinkRSSI2() + " dBm" +
                ", Uplink Link Quality: " + getUplinkLinkQuality() + "%" +
                ", Uplink SNR: " + getUplinkSNR() + " dB" +
                ", Uplink TX Power: " + getUplinkPower() + " mW" +
                ", Active Antenna: " + (getActiveAntenna() == 0 ? "Antenna 1" : "Antenna 2") +
                ", RF Mode: " + getRadioFrequencyMode() +
                ", Downlink RSSI: " + getDownlinkRSSI() + " dBm" +
                ", Downlink Link Quality: " + getDownlinkLinkQuality() + "%" +
                ", Downlink SNR: " + getDownlinkSNR() + " dB";
    }

    // Methods for extracting individual statistics follow:

    public int getUplinkRSSI1() {
        return rawData[3] * -1;  // Convert to dBm
    }

    public int getUplinkRSSI2() {
        return rawData[4] * -1;  // Convert to dBm
    }

    public int getUplinkLinkQuality() {
        return rawData[5];
    }

    public int getUplinkSNR() {
        return rawData[6];
    }

    public int getActiveAntenna() {
        return rawData[7];
    }

    public int getRadioFrequencyMode() {
        return rawData[8];
    }

    public int getUplinkPower() {
        return rawData[9];
    }

    public int getDownlinkRSSI() {
        return rawData[10] * -1;  // Convert to dBm
    }

    public int getDownlinkLinkQuality() {
        return rawData[11];
    }

    public int getDownlinkSNR() {
        return rawData[12];
    }

    /**
     * Builder class for constructing a LinkStatisticsFrame.
     */
    public static class LinkStatisticsBuilder {

        private Address address;
        private int uplinkRSSI1;
        private int uplinkRSSI2;
        private int uplinkLinkQuality;
        private int uplinkSNR;
        private int uplinkPower;
        private int activeAntenna;
        private int radioFrequencyMode;
        private int downlinkRSSI;
        private int downlinkSNR;
        private int downlinkLinkQuality;

        // Methods for setting builder fields and constructing the frame

        public LinkStatisticsBuilder setAddress(final Address address) {
            this.address = address;
            return this;
        }

        public LinkStatisticsBuilder setUplinkRSSI1(int uplinkRSSI1) {
            this.uplinkRSSI1 = uplinkRSSI1;
            return this;
        }

        public LinkStatisticsBuilder setUplinkRSSI2(int uplinkRSSI2) {
            this.uplinkRSSI2 = uplinkRSSI2;
            return this;
        }

        public LinkStatisticsBuilder setUplinkLinkQuality(int uplinkLinkQuality) {
            this.uplinkLinkQuality = uplinkLinkQuality;
            return this;
        }

        public LinkStatisticsBuilder setUplinkSNR(int uplinkSNR) {
            this.uplinkSNR = uplinkSNR;
            return this;
        }

        public LinkStatisticsBuilder setUplinkPower(int uplinkPower) {
            this.uplinkPower = uplinkPower;
            return this;
        }

        public LinkStatisticsBuilder setActiveAntenna(int activeAntenna) {
            this.activeAntenna = activeAntenna;
            return this;
        }

        public LinkStatisticsBuilder setRadioFrequencyMode(int radioFrequencyMode) {
            this.radioFrequencyMode = radioFrequencyMode;
            return this;
        }

        public LinkStatisticsBuilder setDownlinkRSSI(int downlinkRSSI) {
            this.downlinkRSSI = downlinkRSSI;
            return this;
        }

        public LinkStatisticsBuilder setDownlinkSNR(int downlinkSNR) {
            this.downlinkSNR = downlinkSNR;
            return this;
        }

        public LinkStatisticsBuilder setDownlinkLinkQuality(int downlinkLinkQuality) {
            this.downlinkLinkQuality = downlinkLinkQuality;
            return this;
        }

        /**
         * Builds the LinkStatisticsFrame based on the specified parameters.
         *
         * @return a byte array representing the constructed LinkStatistics frame.
         */
        public byte[] build() {
            int packetSize = 14; // Fixed packet size
            int payloadSize = packetSize - 2;  // Address + size byte

            byte[] result = new byte[packetSize];

            result[0] = address.getValue();
            result[1] = (byte) payloadSize;
            result[2] = FrameType.LINK_LINK_STATISTICS.getValue();

            result[3] = (byte) uplinkRSSI1;
            result[4] = (byte) uplinkRSSI2;
            result[5] = (byte) uplinkLinkQuality;
            result[6] = (byte) uplinkSNR;
            result[7] = (byte) activeAntenna;
            result[8] = (byte) radioFrequencyMode;
            result[9] = (byte) uplinkPower;
            result[10] = (byte) downlinkRSSI;
            result[11] = (byte) downlinkLinkQuality;
            result[12] = (byte) downlinkSNR;

            result[packetSize - 1] = CRCHelper.D5(result, 2, result.length - 1);

            return result;
        }
    }

}
