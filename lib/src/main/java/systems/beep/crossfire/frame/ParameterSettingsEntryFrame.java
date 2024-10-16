package systems.beep.crossfire.frame;

import systems.beep.crossfire.frame.sub.CRSFFieldType;

import java.util.Arrays;

/**
 * Represents a CRSF (Crossfire) protocol extended frame for parameter settings entry.
 * <p>
 * The {@code ParameterSettingsEntryFrame} is a response to the frame type {@code 0x2C}.
 * The payload includes the following data:
 * <ul>
 *   <li>Field index</li>
 *   <li>Field chunks remaining</li>
 *   <li>Parent ID</li>
 *   <li>Type/hidden</li>
 *   <li>Label</li>
 *   <li>Value</li>
 * </ul>
 * All strings are ASCII and are sent as null-terminated strings (e.g., "Hi" is sent as {@code 48 69 00}).
 * </p>
 */
public class ParameterSettingsEntryFrame extends CRSFExtendedFrame {

    /**
     * Constructs a {@code ParameterSettingsEntryFrame} using the provided raw data.
     *
     * @param rawData the raw byte array representing the parameter settings entry frame.
     */
    public ParameterSettingsEntryFrame(final byte[] rawData) {
        super(rawData);
    }

    /**
     * Retrieves the payload data from the raw frame, excluding the first five bytes.
     *
     * @return a byte array containing the payload data.
     */
    @Override
    public byte[] getData() {
        return Arrays.copyOfRange(rawData, 5, rawData.length);
    }

    /**
     * Retrieves the field index from the payload.
     * The field index represents the specific parameter being referenced.
     *
     * @return the field index.
     */
    public int getFieldIndex() {
        return getData()[0];
    }

    /**
     * Retrieves the number of chunks remaining for the field data.
     * This indicates how many chunks are left to be received for the parameter.
     *
     * @return the number of chunks remaining.
     */
    public int getChunksRemaining() {
        return getData()[1];
    }

    /**
     * Retrieves the parent ID associated with the parameter.
     * The parent ID links this parameter to a specific parent in the hierarchy.
     *
     * @return the parent ID.
     */
    public int getParentId() {
        return getData()[2];
    }

    /**
     * Retrieves the data type of the field from the payload.
     * The data type is represented by a {@link CRSFFieldType} enumeration.
     * If the type is out of the known range, it returns {@code CRSFFieldType.CRSF_OUT_OF_RANGE}.
     *
     * @return the {@link CRSFFieldType} representing the data type of the field.
     */
    public CRSFFieldType getDataType() {
        return (getData()[3] < 15) ? CRSFFieldType.values()[getData()[3]] : CRSFFieldType.CRSF_OUT_OF_RANGE;
    }

    /**
     * Retrieves the buffer containing the label or value data for the parameter.
     * This excludes the first four bytes of the payload and the last byte (which is the null terminator).
     *
     * @return a byte array containing the label or value data for the parameter.
     */
    public byte[] getBuffer() {
        return Arrays.copyOfRange(getData(), 4, getData().length - 1);
    }

    /**
     * Provides a string representation of the parameter settings entry frame.
     * The string includes the field index, chunks remaining, parent ID, data type, and value.
     *
     * @return a string summarizing the contents of the frame.
     */
    @Override
    public String toString() {
        return "ParameterSettingsEntryFrame |" +
                String.format(" FieldIndex: %d, Chunks: %d, Parent: %d, DataType: %s, Value: %s, Length: %d",
                        getFieldIndex(),
                        getChunksRemaining(),
                        getParentId(),
                        getDataType(),
                        new String(getBuffer()),
                        getBuffer().length);
    }

}
