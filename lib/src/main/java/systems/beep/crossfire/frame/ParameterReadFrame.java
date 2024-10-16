package systems.beep.crossfire.frame;

import systems.beep.crossfire.frame.sub.Address;
import systems.beep.crossfire.frame.sub.FrameType;
import systems.beep.helper.CRCHelper;

/**
 * Represents a CRSF (Crossfire) protocol extended frame for reading parameter details.
 * <p>
 * For each parameter reported in the {@code CRSF_FRAMETYPE_DEVICE_INFO} packet, a
 * {@code CRSF_FRAMETYPE_PARAMETER_READ} extended packet can be sent to read the parameter details.
 * The order and index of these parameters is not fixed, meaning that you cannot simply request
 * a specific field index and expect a predefined parameter (e.g., BIND).
 * </p>
 */
public class ParameterReadFrame extends CRSFExtendedFrame {

    /**
     * Constructs a {@code ParameterReadFrame} using the provided raw data.
     *
     * @param rawData the raw byte array representing the parameter read frame data.
     */
    public ParameterReadFrame(final byte[] rawData) {
        super(rawData);
    }

    /**
     * Returns a new instance of {@code ParameterReadFrameBuilder} for constructing
     * a {@code ParameterReadFrame}.
     *
     * @return a new {@code ParameterReadFrameBuilder}.
     */
    public static ParameterReadFrameBuilder builder() {
        return new ParameterReadFrameBuilder();
    }

    /**
     * Retrieves the size of the parameter read frame.
     * The frame size is fixed at eight bytes.
     *
     * @return the size of the frame, which is always eight bytes.
     */
    @Override
    public int getFrameSize() {
        return 8;
    }

    /**
     * Provides a string representation of the parameter read frame.
     * Currently, this method returns an empty string.
     *
     * @return an empty string.
     */
    @Override
    public String toString() {
        return ""; // TODO: Implement a meaningful string representation
    }

    /**
     * Builder class for constructing {@code ParameterReadFrame} instances.
     * This builder allows setting the source, destination, field index, and chunk index
     * for the frame and generates the byte array representing the parameter read frame.
     */
    public static class ParameterReadFrameBuilder {

        private Address source;

        private Address destination;

        private int fieldIndex = 1;

        private int chunkIndex = 0;

        /**
         * Sets the source address for the frame.
         *
         * @param source the source address.
         * @return the current {@code ParameterReadFrameBuilder} instance.
         */
        public ParameterReadFrameBuilder setSource(final Address source) {
            this.source = source;
            return this;
        }

        /**
         * Sets the destination address for the frame.
         *
         * @param destination the destination address.
         * @return the current {@code ParameterReadFrameBuilder} instance.
         */
        public ParameterReadFrameBuilder setDestination(final Address destination) {
            this.destination = destination;
            return this;
        }

        /**
         * Sets the field index for the frame. The field index is clamped to a minimum of 1.
         *
         * @param fieldIndex the field index to set.
         * @return the current {@code ParameterReadFrameBuilder} instance.
         */
        public ParameterReadFrameBuilder setFieldIndex(int fieldIndex) {
            this.fieldIndex = Math.max(1, fieldIndex);
            return this;
        }

        /**
         * Sets the chunk index for the frame. The chunk index is clamped to a minimum of 0.
         *
         * @param chunkIndex the chunk index to set.
         * @return the current {@code ParameterReadFrameBuilder} instance.
         */
        public ParameterReadFrameBuilder setChunkIndex(int chunkIndex) {
            this.chunkIndex = Math.max(0, chunkIndex);
            return this;
        }

        /**
         * Builds the byte array representing the {@code ParameterReadFrame}.
         * The constructed frame includes the destination address, source address, field index,
         * chunk index, and a CRC checksum.
         *
         * @return a byte array containing the constructed parameter read frame.
         */
        public byte[] build() {
            byte[] result = new byte[8];

            result[0] = destination.getValue();
            result[1] = 6;
            result[2] = FrameType.PARAMETER_SETTINGS_READ.getValue();
            result[3] = destination.getValue();
            result[4] = source.getValue();
            result[5] = (byte) fieldIndex;
            result[6] = (byte) chunkIndex;
            result[7] = CRCHelper.D5(result, 2, result.length - 1);

            return result;
        }

    }

}
