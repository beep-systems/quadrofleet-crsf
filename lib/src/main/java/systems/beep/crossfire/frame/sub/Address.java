package systems.beep.crossfire.frame.sub;

/**
 * Represents the various addresses used in the CRSF (Crossfire) protocol.
 * Each address corresponds to a specific type of device or reserved address
 * within the CRSF ecosystem. The protocol uses these addresses for communication
 * between devices such as receivers, transmitters, flight controllers, and more.
 * <p>
 * For more information, see the
 * <a href="https://github.com/crsf-wg/crsf/wiki/CRSF-Addresses">CRSF Addresses Wiki</a>.
 * </p>
 */
public enum Address {

    /**
     * Broadcast address. All devices process the packet.
     * Corresponds to {@code CRSF_ADDRESS_BROADCAST}.
     */
    BROADCAST(0x00),

    /**
     * USB device address.
     * Corresponds to {@code CRSF_ADDRESS_USB}.
     */
    USB(0x10),

    /**
     * Bluetooth module address.
     * Corresponds to {@code CRSF_ADDRESS_BLUETOOTH}.
     */
    BLUETOOTH(0x12),

    /**
     * TBS CORE PNP PRO device address.
     * Corresponds to {@code CRSF_ADDRESS_TBS_CORE_PNP_PRO}.
     */
    TBS_CORE_PNP_PRO(0x80),

    /**
     * Reserved address (1). May be used for future extensions.
     * Corresponds to {@code CRSF_ADDRESS_RESERVED1}.
     */
    RESERVED_1(0x8A),

    /**
     * External current sensor address.
     * Corresponds to {@code CRSF_ADDRESS_CURRENT_SENSOR}.
     */
    CURRENT_SENSOR(0xC0),

    /**
     * External GPS device address.
     * Corresponds to {@code CRSF_ADDRESS_GPS}.
     */
    GPS(0xC2),

    /**
     * External Blackbox logging device address.
     * Corresponds to {@code CRSF_ADDRESS_TBS_BLACKBOX}.
     */
    TBS_BLACKBOX(0xC4),

    /**
     * Flight Controller address, typically used with Betaflight or iNav.
     * Corresponds to {@code CRSF_ADDRESS_FLIGHT_CONTROLLER}.
     */
    FLIGHT_CONTROLLER(0xC8),

    /**
     * Reserved address (2). May be used for future extensions.
     * Corresponds to {@code CRSF_ADDRESS_RESERVED2}.
     */
    RESERVED_2(0xCA),

    /**
     * Race tag address, possibly used for racing applications.
     * Corresponds to {@code CRSF_ADDRESS_RACE_TAG}.
     */
    RACE_TAG(0xCC),

    /**
     * Radio transmitter (handset) address, such as EdgeTX.
     * This is not the transmitter module itself.
     * Corresponds to {@code CRSF_ADDRESS_RADIO_TRANSMITTER}.
     */
    RADIO_TRANSMITTER(0xEA),

    /**
     * Receiver hardware address, typically for devices like TBS Nano RX or RadioMaster RP1.
     * Corresponds to {@code CRSF_ADDRESS_CRSF_RECEIVER}.
     */
    CRSF_RECEIVER(0xEC),

    /**
     * Transmitter module address, distinct from the handset.
     * Corresponds to {@code CRSF_ADDRESS_CRSF_TRANSMITTER}.
     */
    CRSF_TRANSMITTER(0xEE),

    /**
     * Non-standard source address used by ExpressLRS Lua scripts.
     * Corresponds to {@code CRSF_ADDRESS_ELRS_LUA}.
     */
    ELRS_LUA(0xEF);

    private final byte value;

    /**
     * Constructor for the address enumeration.
     *
     * @param value the byte value representing the address in the CRSF protocol.
     */
    Address(int value) {
        this.value = (byte) value;
    }

    /**
     * Returns the byte value of the address.
     *
     * @return the byte representation of the address.
     */
    public byte getValue() {
        return value;
    }

}