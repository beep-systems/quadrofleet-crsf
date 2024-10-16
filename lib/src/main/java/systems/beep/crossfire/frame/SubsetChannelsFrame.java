package systems.beep.crossfire.frame;

/**
 * Represents a frame containing a subset of RC channels in the CRSF protocol.
 * <p>
 * The SubsetChannelsFrame corresponds to the CRSF_FRAMETYPE_SUBSET_RC_CHANNELS_PACKED (0x17),
 * which is used to transmit a subset of RC (Remote Control) channel data. For more details,
 * see the <a href="https://github.com/crsf-wg/crsf/wiki/CRSF_FRAMETYPE_SUBSET_RC_CHANNELS_PACKED">Wiki</a>.
 * </p>
 *
 * @see CRSFFrame
 */
public class SubsetChannelsFrame extends CRSFFrame {

    /**
     * Constructs a SubsetChannelsFrame using the provided raw data.
     *
     * @param rawData the raw byte array representing the Subset Channels frame.
     *                This data should conform to the structure defined by the CRSF protocol.
     */
    public SubsetChannelsFrame(final byte[] rawData) {
        super(rawData);
    }

    /**
     * Provides a string representation of the SubsetChannelsFrame.
     *
     * @return an empty string since the representation is not yet implemented.
     */
    @Override
    public String toString() {
        return ""; // TODO: Implement a meaningful string representation
    }

    /**
     * Retrieves the origin device address from the raw data.
     *
     * @return a float representing the origin device address. Currently, returns 0 as a placeholder.
     */
    public float getOriginDeviceAddress() {
        return 0; // TODO: Implement retrieval of the actual origin device address
    }

}
