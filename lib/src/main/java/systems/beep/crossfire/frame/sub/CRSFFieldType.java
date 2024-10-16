package systems.beep.crossfire.frame.sub;

/**
 * Enumeration representing the different field types available in the CRSF (Crossfire) protocol.
 * <p>
 * The {@code CRSFFieldType} enum is used to define the various data types that can be included
 * in CRSF communication frames. These types include integers, floating-point numbers, strings,
 * commands, and other specialized field types such as VTX (Video Transmitter) and status indicators.
 * </p>
 */
public enum CRSFFieldType {

    /**
     * Unsigned 8-bit integer field type.
     */
    CRSF_UINT_8("UINT8"),

    /**
     * Signed 8-bit integer field type.
     */
    CRSF_INT_8("INT8"),

    /**
     * Unsigned 16-bit integer field type.
     */
    CRSF_UINT_16("UINT16"),

    /**
     * Signed 16-bit integer field type.
     */
    CRSF_INT_16("INT16"),

    /**
     * Unsigned 32-bit integer field type.
     */
    CRSF_UINT_32("UINT32"),

    /**
     * Signed 32-bit integer field type.
     */
    CRSF_INT_32("INT32"),

    /**
     * Unsigned 64-bit integer field type.
     */
    CRSF_UINT_64("UINT64"),

    /**
     * Signed 64-bit integer field type.
     */
    CRSF_INT_64("INT64"),

    /**
     * Floating-point number field type.
     */
    CRSF_FLOAT("FLOAT"),

    /**
     * Text selection field type.
     */
    CRSF_TEXT_SELECTION("SELECT"),

    /**
     * String field type.
     */
    CRSF_STRING("STRING"),

    /**
     * Folder field type, typically used to represent a hierarchical structure.
     */
    CRSF_FOLDER("FOLDER"),

    /**
     * Info field type, used to convey information without an editable value.
     */
    CRSF_INFO("INFO"),

    /**
     * Command field type, used to represent actions or commands in the protocol.
     */
    CRSF_COMMAND("COMMAND"),

    /**
     * VTX (Video Transmitter) field type.
     */
    CRSF_VTX("VTX"),

    /**
     * Status field type, used for suppressing critical errors.
     */
    CRSF_STATUS("suppress-critical-errors"),

    /**
     * Out-of-range field type, used to represent values that exceed the expected range.
     */
    CRSF_OUT_OF_RANGE("OUT-OF-RANGE");

    // The value representing the field type.
    private final String value;

    /**
     * Constructs a {@code CRSFFieldType} with the specified value.
     *
     * @param value the string representation of the field type.
     */
    CRSFFieldType(String value) {
        this.value = value;
    }

    /**
     * Retrieves the string value associated with this field type.
     *
     * @return the string representation of the field type.
     */
    public String getValue() {
        return value;
    }

}
