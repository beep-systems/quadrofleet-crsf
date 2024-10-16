package systems.beep.crossfire.frame;

import systems.beep.crossfire.frame.sub.Address;
import systems.beep.crossfire.frame.sub.FrameType;
import systems.beep.helper.CRCHelper;

/**
 * Represents a device ping frame that initiates a communication
 * request to a device.
 * <p>
 * The slave (transmitter module, receiver, flight controller, etc.) replies to
 * CRSF_FRAMETYPE_DEVICE_PING with an extended frame type CRSF_FRAMETYPE_DEVICE_INFO
 * if the ping's destination matches the device's type.
 * This frame contains the source and destination addresses along with a
 * synchronization byte.
 * </p>
 */
public class DevicePingFrame extends CRSFExtendedFrame {

    /**
     * Constructs a DevicePingFrame using the provided raw data.
     *
     * @param rawData the raw byte array representing the device ping frame.
     */
    public DevicePingFrame(final byte[] rawData) {
        super(rawData);
    }

    /**
     * Returns a new instance of the DevicePingFrameBuilder.
     *
     * @return a DevicePingFrameBuilder for constructing a new frame.
     */
    public static DevicePingFrameBuilder builder() {
        return new DevicePingFrameBuilder();
    }

    /**
     * Returns the size of the frame.
     *
     * @return the size of the frame as an integer.
     */
    @Override
    public int getFrameSize() {
        return 6; // Fixed size for DevicePingFrame
    }

    /**
     * Provides a string representation of the DevicePingFrame.
     *
     * @return a string summarizing the frame details.
     */
    @Override
    public String toString() {
        return "DevicePingFrame |" +
                " Source: " + getSource() +
                ", Destination: " + getDestination();
    }

    /**
     * Builder class for constructing a DevicePingFrame.
     */
    public static class DevicePingFrameBuilder {

        private Address source;        // The source address of the frame

        private Address destination;   // The destination address of the frame

        /**
         * Sets the source address for the frame.
         *
         * @param source the source address.
         * @return the builder instance for method chaining.
         */
        public DevicePingFrameBuilder setSource(final Address source) {
            this.source = source;
            return this;
        }

        /**
         * Sets the destination address for the frame.
         *
         * @param destination the destination address.
         * @return the builder instance for method chaining.
         */
        public DevicePingFrameBuilder setDestination(final Address destination) {
            this.destination = destination;
            return this;
        }

        /**
         * Constructs and returns a byte array representing the DevicePingFrame.
         *
         * @return the constructed byte array for the frame.
         */
        public byte[] build() {
            byte[] result = new byte[6];

            result[0] = FRAME_SYNC_BYTE; // Sync byte
            result[1] = 4; // Payload size (excluding sync byte)
            result[2] = FrameType.DEVICE_PING.getValue(); // Frame type
            result[3] = destination.getValue(); // Destination address
            result[4] = source.getValue(); // Source address
            result[5] = CRCHelper.D5(result, 2, result.length - 1); // CRC

            return result;
        }
    }

}
