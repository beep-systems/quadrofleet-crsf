package systems.beep.crossfire.frame.sub;

/**
 * Represents the various commands used in the CRSF (Crossfire) protocol.
 * Each command corresponds to a specific type of action or message
 * that can be sent within the protocol. These commands are used
 * for controlling different functionalities, such as receiver settings
 * or general configurations.
 * <p>
 * For more information, see the
 * <a href="https://github.com/crsf-wg/crsf/wiki/CRSF_FRAMETYPE_COMMAND">CRSF Command Wiki</a>.
 * </p>
 */
public enum Command {

    /**
     * Receiver-specific command.
     * Typically used for controlling or configuring the receiver settings.
     * Corresponds to {@code CRSF_COMMAND_SUBCMD_RX}.
     */
    RX(0x10),

    /**
     * General command used for various other configurations
     * that do not fall under a specific category.
     * Corresponds to {@code CRSF_COMMAND_SUBCMD_GENERAL}.
     */
    GENERAL(0x0A);

    private final int value;

    /**
     * Constructor for the command enumeration.
     *
     * @param value the integer value representing the command in the CRSF protocol.
     */
    Command(int value) {
        this.value = value;
    }

    /**
     * Returns the integer value of the command.
     *
     * @return the integer representation of the command.
     */
    public int getValue() {
        return value;
    }

}
