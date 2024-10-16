package systems.beep.crossfire.frame;

import java.util.Arrays;

/**
 * Represents a response to a device ping containing information about the device.
 * <p>
 * The slave (transmitter module, receiver, flight controller, etc.) replies to
 * CRSF_FRAMETYPE_DEVICE_PING with an extended frame type CRSF_FRAMETYPE_DEVICE_INFO
 * if the ping's destination matches the device's type.
 * This frame contains the device display name, serial number, hardware version,
 * software version, field count, and parameter protocol version.
 * </p>
 * <p>
 * CRSF_FRAMETYPE_DEVICE_INFO<br>
 * Device Info / device ping response (0x29)<br>
 * <a href="https://github.com/crsf-wg/crsf/wiki/CRSF_FRAMETYPE_DEVICE_INFO">Wiki</a>
 * </p>
 */
public class DeviceInfoFrame extends CRSFExtendedFrame {

    private final int offset; // Offset used for parsing the device info data

    /**
     * Constructs a DeviceInfoFrame with the provided raw data.
     *
     * @param rawData the raw byte array representing the device info frame.
     */
    public DeviceInfoFrame(final byte[] rawData) {
        super(rawData);
        // Find the offset to extract the correct device name from the data
        offset = systems.beep.helper.TelemetryHelper.findOffset(getData()) + 1;
    }

    /**
     * Provides a string representation of the DeviceInfoFrame.
     *
     * @return a string summarizing the device's information.
     */
    @Override
    public String toString() {
        return "DeviceInfoFrame |" +
                " Device Name: " + getDeviceName() +
                ", Serial: " + getSerialNumber() +
                ", HW Version: " + getHardwareVersion() +
                ", SW Version: " + getSoftwareVersion() +
                ", Field Count: " + getFieldCount() +
                ", Param Version: " + getParameterVersion();
    }

    /**
     * Retrieves the device name from the data.
     *
     * @return the device's display name as a string.
     */
    public String getDeviceName() {
        return new String(Arrays.copyOfRange(getData(), 0, offset - 1));
    }

    /**
     * Retrieves the serial number of the device.
     *
     * @return the serial number as a string.
     */
    public String getSerialNumber() {
        return new String(Arrays.copyOfRange(getData(), offset, offset + 4));
    }

    /**
     * Retrieves the hardware version of the device.
     *
     * @return the hardware version formatted as a string (e.g., "1.0.0").
     */
    public String getHardwareVersion() {
        return String.format("%d.%d.%d", getData()[offset + 5], getData()[offset + 6], getData()[offset + 7]);
    }

    /**
     * Retrieves the software version of the device.
     *
     * @return the software version formatted as a string (e.g., "1.0.0").
     */
    public String getSoftwareVersion() {
        return String.format("%d.%d.%d", getData()[offset + 9], getData()[offset + 10], getData()[offset + 11]);
    }

    /**
     * Retrieves the field count of the device.
     *
     * @return the number of fields as an integer.
     */
    public int getFieldCount() {
        return getData()[offset + 12];
    }

    /**
     * Retrieves the parameter version of the device.
     *
     * @return the parameter version as an integer.
     */
    public int getParameterVersion() {
        return getData()[offset + 13];
    }

    /**
     * Determines if the frame can be ignored.
     *
     * @return false, indicating that this frame contains important information.
     */
    @Override
    public boolean isIgnorable() {
        return false;
    }

}
