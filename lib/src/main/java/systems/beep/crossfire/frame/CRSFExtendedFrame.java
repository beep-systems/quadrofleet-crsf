package systems.beep.crossfire.frame;

import systems.beep.crossfire.frame.sub.Address;
import systems.beep.crossfire.frame.sub.FrameType;
import systems.beep.exception.IncorrectAddressException;
import systems.beep.exception.IncorrectFrameTypeException;

import java.util.Arrays;

/**
 * Represents an extended CRSF frame that contains additional information,
 * such as destination and source addresses, as well as the frame type.
 */
public abstract class CRSFExtendedFrame extends CRSFFrame {

    public static final int MIN_SIZE = 6; // Minimum size of the CRSF extended frame

    /**
     * Constructs a CRSFExtendedFrame with the given raw data.
     *
     * @param data the raw byte array representing the extended frame.
     */
    protected CRSFExtendedFrame(final byte[] data) {
        super(data);
    }

    /**
     * Retrieves the destination address from the frame.
     *
     * @return the destination {@link Address} of the frame.
     * @throws IncorrectAddressException if the destination address is invalid.
     */
    public Address getDestination() {
        return Arrays.stream(Address.values())
                .filter(item -> item.getValue() == rawData[3])
                .findAny()
                .orElseThrow(IncorrectAddressException::new);
    }

    /**
     * Retrieves the source address from the frame.
     *
     * @return the source {@link Address} of the frame.
     * @throws IncorrectAddressException if the source address is invalid.
     */
    public Address getSource() {
        return Arrays.stream(Address.values())
                .filter(item -> item.getValue() == rawData[4])
                .findAny()
                .orElseThrow(IncorrectAddressException::new);
    }

    /**
     * Retrieves the extended frame type from the frame.
     *
     * @return the {@link FrameType} of the frame.
     * @throws IncorrectFrameTypeException if the frame type is invalid.
     */
    public FrameType getExtendedFrameType() {
        return Arrays.stream(FrameType.values())
                .filter(item -> item.getValue() == rawData[5])
                .findAny()
                .orElseThrow(IncorrectFrameTypeException::new);
    }

    /**
     * Retrieves the data payload of the frame.
     *
     * @return a byte array containing the data from the frame.
     */
    public byte[] getData() {
        return Arrays.copyOfRange(rawData, 6, rawData.length);
    }

}
