package systems.beep.crossfire.frame.sub;

/**
 * Represents various subcommands used within the CRSF (Crossfire) protocol.
 * Subcommands specify particular actions or settings related to communication
 * between devices, such as entering binding mode or setting the CRSF port speed.
 * These subcommands are part of the CRSF command structure and are used to
 * manage device-specific configurations and responses.
 * <p>
 * For more information, see the
 * <a href="https://github.com/betaflight/betaflight/blob/master/src/main/rx/crsf_protocol.h#L64">Betaflight CRSF Protocol</a>.
 * </p>
 */
public enum Subcommand {

    /**
     * Enter receiver binding mode. Used to initiate the process of
     * binding the receiver to a transmitter.
     * Corresponds to {@code CRSF_COMMAND_SUBCMD_RX_BIND}.
     */
    RX_BIND(0x01),

    /**
     * Set the receiver or model identification number. This subcommand is
     * used for selecting a specific model ID on the receiver.
     * Corresponds to {@code COMMAND_MODEL_SELECT_ID}.
     */
    MODEL_SELECT_ID(0x05),

    /**
     * Propose a new CRSF port speed. Used to suggest a change in the communication
     * baud rate for the CRSF protocol.
     * Corresponds to {@code CRSF_COMMAND_SUBCMD_GENERAL_CRSF_SPEED_PROPOSAL}.
     */
    SPEED_PROPOSAL(0x70),

    /**
     * Response to the proposed CRSF port speed change. Used to acknowledge or
     * confirm the proposed new baud rate.
     * Corresponds to {@code CRSF_COMMAND_SUBCMD_GENERAL_CRSF_SPEED_RESPONSE}.
     */
    SPEED_RESPONSE(0x71);

    private final int value;

    /**
     * Constructor for the subcommand enumeration.
     *
     * @param value the integer value representing the subcommand in the CRSF protocol.
     */
    Subcommand(int value) {
        this.value = value;
    }

    /**
     * Returns the integer value of the subcommand.
     *
     * @return the integer representation of the subcommand.
     */
    public int getValue() {
        return value;
    }
    
}
