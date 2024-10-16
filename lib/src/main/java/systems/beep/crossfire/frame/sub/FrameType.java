package systems.beep.crossfire.frame.sub;

/**
 * Represents the various frame types used in the CRSF (Crossfire) protocol.
 * Each frame type corresponds to a specific type of data or command that can be sent
 * between devices in the CRSF ecosystem, such as telemetry data, configuration commands,
 * or device information. Frame types are identified by a byte value that determines the
 * content and handling of the associated packet.
 * <p>
 * For more information, see the
 * <a href="https://github.com/crsf-wg/crsf/wiki/Packet-Types">CRSF Packet Types Wiki</a>.
 * </p>
 */
public enum FrameType {

    /**
     * GPS data frame. Contains information such as position, ground speed,
     * heading, altitude, and satellite count.
     */
    GPS(0x02),

    /**
     * Vario data frame. Represents vertical speed.
     */
    VARIO(0x07),

    /**
     * Battery sensor data frame. Includes battery voltage, current, mAh consumed,
     * and remaining battery percentage.
     */
    BATTERY_SENSOR(0x08),

    /**
     * Barometric altitude frame. May also include vertical speed data.
     */
    BARO_ALTITUDE(0x09),

    /**
     * Heartbeat frame for CRSFv3. Used to monitor connectivity status.
     */
    HEARTBEAT(0x0B),

    /**
     * Link statistics frame. Provides information such as uplink/downlink RSSI,
     * SNR, Link Quality (LQ), RF mode, and transmit power.
     */
    LINK_LINK_STATISTICS(0x14),

    /**
     * Packed RC channels data. Used for transmitting control channels from
     * handset to transmitter and from receiver to flight controller.
     */
    RC_CHANNELS_PACKED(0x16),

    /**
     * Subset of packed RC channels data for CRSFv3.
     */
    SUBSET_RC_CHANNELS_PACKED(0x17),

    /**
     * Link receiver identification frame. Contains RSSI percentage and possibly power.
     */
    LINK_RX_ID(0x1C),

    /**
     * Link transmitter identification frame. Contains RSSI percentage, power, and possibly frames per second.
     */
    LINK_TX_ID(0x1D),

    /**
     * Attitude frame. Includes pitch, roll, and yaw data.
     */
    ATTITUDE(0x1E),

    /**
     * Flight mode frame. Represents the current flight controller mode as a string.
     */
    FLIGHT_MODE(0x21),

    /**
     * Device ping frame. Used by the sender to request DEVICE_INFO from all destination devices.
     */
    DEVICE_PING(0x28),

    /**
     * Device information frame. Provides details such as device name, firmware version,
     * hardware version, and serial number in response to a DEVICE_PING.
     */
    DEVICE_INFO(0x29),

    /**
     * Frame for requesting settings.
     */
    REQUEST_SETTINGS(0x2A),

    /**
     * Parameter settings entry frame. Used for sending configuration item data chunks.
     */
    PARAMETER_SETTINGS_ENTRY(0x2B),

    /**
     * Parameter settings read request frame.
     */
    PARAMETER_SETTINGS_READ(0x2C),

    /**
     * Parameter settings write request frame.
     */
    PARAMETER_SETTINGS_WRITE(0x2D),

    /**
     * ExpressLRS status frame. Contains information on good/bad packet count and status flags.
     */
    ELRS_STATUS(0x2E),

    /**
     * Command execution frame for CRSF commands.
     */
    COMMAND(0x32),

    /**
     * Radio ID frame used for extended types such as OPENTX_SYNC.
     */
    RADIO_ID(0x3A),

    /**
     * KISS request frame.
     */
    KISS_REQ(0x78),

    /**
     * KISS response frame.
     */
    KISS_RESP(0x79),

    /**
     * MSP parameter request or command frame.
     */
    MSP_REQ(0x7A),

    /**
     * MSP parameter response frame.
     */
    MSP_RESP(0x7B),

    /**
     * MSP parameter write frame.
     */
    MSP_WRITE(0x7C),

    /**
     * DisplayPort control command frame for CRSFv3.
     */
    DISPLAYPORT_CMD(0x7D),

    /**
     * Ardupilot response frame.
     */
    ARDUPILOT_RESP(0x80),

    /**
     * UART synchronization frame.
     */
    UART_SYNC(0xC8),

    /**
     * Command frame for model selection.
     */
    CMD_MODEL_SELECT(0x05),

    /**
     * Frame used for OpenTX synchronization.
     */
    OPEN_TX_SYNC(0x10);

    private final byte value;

    /**
     * Constructor for the frame type enumeration.
     *
     * @param value the byte value representing the frame type in the CRSF protocol.
     */
    FrameType(int value) {
        this.value = (byte) value;
    }

    /**
     * Returns the byte value of the frame type.
     *
     * @return the byte representation of the frame type.
     */
    public byte getValue() {
        return value;
    }

}
