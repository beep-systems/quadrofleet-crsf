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

    /**
     * Gets the RSSI for the first uplink antenna.
     *
     * @return the RSSI in dBm for the first uplink antenna.
     */
    public int getUplinkRSSI1() {
        return rawData[3] * -1;  // Convert to dBm
    }

    /**
     * Gets the RSSI for the second uplink antenna.
     *
     * @return the RSSI in dBm for the second uplink antenna.
     */
    public int getUplinkRSSI2() {
        return rawData[4] * -1;  // Convert to dBm
    }

    /**
     * Gets the uplink link quality.
     *
     * @return the uplink link quality as a percentage.
     */
    public int getUplinkLinkQuality() {
        return rawData[5];
    }

    /**
     * Gets the Signal-to-Noise Ratio (SNR) for the uplink.
     *
     * @return the uplink SNR in dB.
     */
    public int getUplinkSNR() {
        return rawData[6];
    }

    /**
     * Gets the active antenna identifier.
     *
     * @return 0 for Antenna 1, 1 for Antenna 2.
     */
    public int getActiveAntenna() {
        return rawData[7];
    }

    /**
     * Gets the radio frequency mode.
     *
     * @return the RF mode identifier.
     */
    public int getRadioFrequencyMode() {
        return rawData[8];
    }

    /**
     * Gets the transmitted power for the uplink.
     *
     * @return the transmitting power in milli watts (mW).
     */
    public int getUplinkPower() {
        return rawData[9];
    }

    /**
     * Gets the RSSI for the downlink.
     *
     * @return the RSSI in dBm for the downlink.
     */
    public int getDownlinkRSSI() {
        return rawData[10] * -1;  // Convert to dBm
    }

    /**
     * Gets the downlink link quality.
     *
     * @return the downlink link quality as a percentage.
     */
    public int getDownlinkLinkQuality() {
        return rawData[11];
    }

    /**
     * Gets the Signal-to-Noise Ratio (SNR) for the downlink.
     *
     * @return the downlink SNR in dB.
     */
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

        /**
         * Sets the address for the LinkStatistics frame.
         *
         * @param address the address to set.
         * @return the builder instance.
         */
        public LinkStatisticsBuilder setAddress(final Address address) {
            this.address = address;
            return this;
        }

        /**
         * Sets the uplink RSSI for antenna 1.
         *
         * @param uplinkRSSI1 the uplink RSSI in dBm for antenna 1.
         * @return the builder instance.
         */
        public LinkStatisticsBuilder setUplinkRSSI1(int uplinkRSSI1) {
            this.uplinkRSSI1 = uplinkRSSI1;
            return this;
        }

        /**
         * Sets the uplink RSSI for antenna 2.
         *
         * @param uplinkRSSI2 the uplink RSSI in dBm for antenna 2.
         * @return the builder instance.
         */
        public LinkStatisticsBuilder setUplinkRSSI2(int uplinkRSSI2) {
            this.uplinkRSSI2 = uplinkRSSI2;
            return this;
        }

        /**
         * Sets the uplink link quality.
         *
         * @param uplinkLinkQuality the uplink link quality as a percentage.
         * @return the builder instance.
         */
        public LinkStatisticsBuilder setUplinkLinkQuality(int uplinkLinkQuality) {
            this.uplinkLinkQuality = uplinkLinkQuality;
            return this;
        }

        /**
         * Sets the Signal-to-Noise Ratio (SNR) for the uplink.
         *
         * @param uplinkSNR the uplink SNR in dB.
         * @return the builder instance.
         */
        public LinkStatisticsBuilder setUplinkSNR(int uplinkSNR) {
            this.uplinkSNR = uplinkSNR;
            return this;
        }

        /**
         * Sets the transmit power for the uplink.
         *
         * @param uplinkPower the transmit power in milliwatts (mW).
         * @return the builder instance.
         */
        public LinkStatisticsBuilder setUplinkPower(int uplinkPower) {
            this.uplinkPower = uplinkPower;
            return this;
        }

        /**
         * Sets the active antenna identifier.
         *
         * @param activeAntenna 0 for Antenna 1, 1 for Antenna 2.
         * @return the builder instance.
         */
        public LinkStatisticsBuilder setActiveAntenna(int activeAntenna) {
            this.activeAntenna = activeAntenna;
            return this;
        }

        /**
         * Sets the radio frequency mode.
         *
         * @param radioFrequencyMode the RF mode identifier.
         * @return the builder instance.
         */
        public LinkStatisticsBuilder setRadioFrequencyMode(int radioFrequencyMode) {
            this.radioFrequencyMode = radioFrequencyMode;
            return this;
        }

        /**
         * Sets the downlink RSSI.
         *
         * @param downlinkRSSI the RSSI in dBm for the downlink.
         * @return the builder instance.
         */
        public LinkStatisticsBuilder setDownlinkRSSI(int downlinkRSSI) {
            this.downlinkRSSI = downlinkRSSI;
            return this;
        }

        /**
         * Sets the Signal-to-Noise Ratio (SNR) for the downlink.
         *
         * @param downlinkSNR the downlink SNR in dB.
         * @return the builder instance.
         */
        public LinkStatisticsBuilder setDownlinkSNR(int downlinkSNR) {
            this.downlinkSNR = downlinkSNR;
            return this;
        }

        /**
         * Sets the downlink link quality.
         *
         * @param downlinkLinkQuality the downlink link quality as a percentage.
         * @return the builder instance.
         */
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
