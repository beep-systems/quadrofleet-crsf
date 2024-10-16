package systems.beep.crossfire.frame;

import systems.beep.crossfire.frame.sub.Address;
import systems.beep.crossfire.frame.sub.FrameType;
import systems.beep.helper.CRCHelper;
import systems.beep.helper.TelemetryHelper;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * Represents a CRSF (Crossfire) protocol frame for packed RC channels data.
 * This frame type is used to transmit channel data between a handset and a transmitter
 * (TX) or between a receiver (RX) and a flight controller.
 * It is identified by the frame type code {@code 0x16}, which corresponds to
 * {@code CRSF_FRAMETYPE_RC_CHANNELS_PACKED}.
 * <p>
 * For more information, see the
 * <a href="https://github.com/crsf-wg/crsf/wiki/CRSF_FRAMETYPE_RC_CHANNELS_PACKED">CRSF Wiki</a>.
 * </p>
 */
public class ChannelsFrame extends CRSFFrame {

    /**
     * Constructs a {@code ChannelsFrame} from the given raw byte array.
     *
     * @param rawData the raw byte array representing the frame data.
     */
    public ChannelsFrame(final byte[] rawData) {
        super(rawData);
    }

    /**
     * Returns a new instance of {@code ChannelsFrameBuilder} for building a
     * {@code ChannelsFrame}.
     *
     * @return a new {@code ChannelsFrameBuilder}.
     */
    public static ChannelsFrameBuilder builder() {
        return new ChannelsFrameBuilder();
    }

    /**
     * Provides a string representation of the channels frame.
     * This representation includes the address and the channel values.
     *
     * @return a string representation of the frame.
     */
    @Override
    public String toString() {
        return "ChannelsFrame |" +
                " Address: " + getAddress() +
                ", Channels: " + Arrays.toString(getChannels());
    }

    /**
     * Retrieves the RC channel data as an array of microseconds.
     * The raw channel data is unpacked from the frame and then converted from
     * the CRSF representation to microseconds.
     *
     * @return an array containing the channel data in microseconds.
     */
    public int[] getChannels() {
        int[] result = new int[16];
        TelemetryHelper.unpackChannels(Arrays.copyOfRange(rawData, 3, rawData.length - 1), result);

        for (int i = 0; i < result.length; i++) {
            result[i] = TelemetryHelper.convertCRSFToMicroseconds(result[i]);
        }

        return result;
    }

    /**
     * Builder class for constructing {@code ChannelsFrame} instances.
     * This builder allows setting the address and the RC channels data, then
     * generates a byte array representing the channels frame.
     */
    public static class ChannelsFrameBuilder {

        private Address address;

        private byte[] channels;

        /**
         * Sets the address for the frame.
         *
         * @param address the source or destination address for the frame.
         * @return the current {@code ChannelsFrameBuilder} instance.
         */
        public ChannelsFrameBuilder setAddress(final Address address) {
            this.address = address;
            return this;
        }

        /**
         * Sets the RC channel data to be included in the frame.
         * The data is provided as an array of channel values in microseconds,
         * which are then converted to the CRSF representation.
         *
         * @param channels an array of channel data in microseconds.
         * @return the current {@code ChannelsFrameBuilder} instance.
         */
        public ChannelsFrameBuilder setChannels(final int[] channels) {
            this.channels = new byte[22];
            int[] convertedChannels = new int[channels.length];

            for (int i = 0; i < channels.length; i++) {
                convertedChannels[i] = TelemetryHelper.convertMicrosecondsToCRSF(channels[i]);
            }

            TelemetryHelper.packChannels(convertedChannels, this.channels);
            return this;
        }

        /**
         * Builds the byte array representing the channels frame.
         * The constructed frame includes the address, payload size, frame type,
         * packed channel data, and CRC.
         *
         * @return a byte array containing the constructed frame.
         */
        public byte[] build() {
            int packetSize = channels.length + 4;
            int payloadSize = channels.length + 2;

            byte[] result = new byte[packetSize];

            result[0] = address.getValue();
            result[1] = (byte) payloadSize;
            result[2] = FrameType.RC_CHANNELS_PACKED.getValue();

            ByteBuffer buffer = ByteBuffer.wrap(result);
            buffer.position(3);
            buffer.put(this.channels);

            // Calculate the CRC and set it in the last byte
            result[packetSize - 1] = CRCHelper.D5(result, 2, result.length - 1);

            return result;
        }
    }

}
