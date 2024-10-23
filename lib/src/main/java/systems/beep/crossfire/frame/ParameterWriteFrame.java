package systems.beep.crossfire.frame;

import systems.beep.crossfire.frame.sub.Address;
import systems.beep.crossfire.frame.sub.FrameType;
import systems.beep.helper.CRCHelper;

/**
 * Represents a CRSF (Crossfire) protocol extended frame for writing or executing a command parameter.
 * <p>
 * The {@code ParameterWriteFrame} is used to set a parameter value or execute a command in the CRSF protocol.
 * The payload consists of the following data:
 * <ul>
 *   <li>Field index</li>
 *   <li>Value (dependent on the field type)</li>
 * </ul>
 * The field indexes are not fixed, meaning you cannot assume a specific field index for specific commands
 * (e.g., setting field 11 does not necessarily correspond to the BIND command).
 */
public class ParameterWriteFrame extends CRSFExtendedFrame {

    /**
     * Constructs a {@code ParameterWriteFrame} using the provided raw data.
     *
     * @param rawData the raw byte array representing the parameter write frame data.
     */
    public ParameterWriteFrame(final byte[] rawData) {
        super(rawData);
    }

    /**
     * Returns a new instance of {@code ParameterWriteFrameBuilder} for constructing
     * a {@code ParameterWriteFrame}.
     *
     * @return a new {@code ParameterWriteFrameBuilder}.
     */
    public static ParameterWriteFrameBuilder builder() {
        return new ParameterWriteFrameBuilder();
    }

    /**
     * Retrieves the size of the parameter write frame.
     * The frame size is fixed at 8 bytes.
     *
     * @return the size of the frame, which is always 8 bytes.
     */
    @Override
    public int getFrameSize() {
        return 8;
    }

    /**
     * Provides a string representation of the parameter write frame.
     * Currently, this method returns an empty string.
     *
     * @return an empty string.
     */
    @Override
    public String toString() {
        return ""; // TODO: Implement a meaningful string representation
    }

    /**
     * Builder class for constructing {@code ParameterWriteFrame} instances.
     * This builder allows setting the source, destination, field index, and value
     * for the frame and generates the byte array representing the parameter write frame.
     */
    public static class ParameterWriteFrameBuilder {

        private Address source;
        private Address destination;
        private int fieldIndex;
        private int value;

        /**
         * Sets the source address for the frame.
         *
         * @param source the source address.
         * @return the current {@code ParameterWriteFrameBuilder} instance.
         */
        public ParameterWriteFrameBuilder setSource(final Address source) {
            this.source = source;
            return this;
        }

        /**
         * Sets the destination address for the frame.
         *
         * @param destination the destination address.
         * @return the current {@code ParameterWriteFrameBuilder} instance.
         */
        public ParameterWriteFrameBuilder setDestination(final Address destination) {
            this.destination = destination;
            return this;
        }

        /**
         * Sets the field index for the frame. The field index is clamped to a minimum of 1.
         *
         * @param fieldIndex the field index to set.
         * @return the current {@code ParameterWriteFrameBuilder} instance.
         */
        public ParameterWriteFrameBuilder setFieldIndex(int fieldIndex) {
            this.fieldIndex = Math.max(1, fieldIndex);
            return this;
        }

        /**
         * Sets the value for the frame. The value is clamped to a minimum of 0.
         *
         * @param value the value to set for the parameter.
         * @return the current {@code ParameterWriteFrameBuilder} instance.
         */
        public ParameterWriteFrameBuilder setValue(int value) {
            this.value = Math.max(0, value);
            return this;
        }

        /**
         * Builds the byte array representing the {@code ParameterWriteFrame}.
         * The constructed frame includes the sync byte, payload size, frame type,
         * source, destination, field index, value, and CRC checksum.
         *
         * @return a byte array containing the constructed parameter write frame.
         */
        public byte[] build() {
            byte[] result = new byte[8];

            result[0] = FRAME_SYNC_BYTE;
            result[1] = 8;
            result[2] = FrameType.PARAMETER_SETTINGS_WRITE.getValue();
            result[3] = destination.getValue();
            result[4] = source.getValue();
            result[5] = (byte) fieldIndex;
            result[6] = (byte) value;
            result[7] = CRCHelper.D5(result, 2, result.length - 1);

            return result;
        }

    }

}
