package systems.beep.crossfire.frame;

import java.nio.ByteBuffer;

/**
 * Represents a CRSF (Crossfire) protocol frame for battery sensor telemetry data.
 * The battery frame provides information about the battery's voltage, current, used capacity,
 * and estimated remaining percentage. This frame type is identified by the frame type code
 * {@code 0x08}, which corresponds to {@code CRSF_FRAMETYPE_BATTERY_SENSOR}.
 * <p>
 * For more details, see the
 * <a href="https://github.com/crsf-wg/crsf/wiki/CRSF_FRAMETYPE_BATTERY_SENSOR">CRSF Battery Sensor Wiki</a>.
 * </p>
 */
public class BatteryFrame extends CRSFFrame {

    /**
     * Constructs a {@code BatteryFrame} from the raw data received in a CRSF packet.
     *
     * @param rawData the raw byte array representing the frame data.
     */
    public BatteryFrame(final byte[] rawData) {
        super(rawData);
    }

    /**
     * Returns the size of the battery sensor frame.
     * The frame size is fixed at 12 bytes.
     *
     * @return the size of the frame, which is always 12 bytes.
     */
    @Override
    public int getFrameSize() {
        return 12;
    }

    /**
     * Provides a string representation of the battery frame, including the voltage,
     * current, used capacity (fuel), and remaining percentage.
     *
     * @return a string describing the frame with battery information.
     */
    @Override
    public String toString() {
        return "BatteryFrame |" +
                " Voltage (V): " + getVoltage() +
                ", Current (A): " + getCurrent() +
                ", Used capacity - fuel (mAh): " + getFuel() +
                ", Remaining (%): " + getRemaining();
    }

    /**
     * Returns the battery voltage in volts.
     * The voltage value is provided in decivolts (dV) and is extracted from
     * the raw data as a big-endian 16-bit integer. The result is divided by 10
     * to convert it to volts.
     *
     * @return the voltage in volts.
     */
    public double getVoltage() {
        short value = (short) ((rawData[3] & 0xFF) | ((rawData[4] & 0xFF) << 8));
        return Short.reverseBytes(value) / 10.0;
    }

    /**
     * Returns the battery current in amperes.
     * The current value is provided in deciamperes (dA) and is extracted from
     * the raw data as a big-endian 16-bit integer. The result is divided by 10
     * to convert it to amperes.
     *
     * @return the current in amperes.
     */
    public double getCurrent() {
        short value = (short) ((rawData[5] & 0xFF) | ((rawData[6] & 0xFF) << 8));
        return Short.reverseBytes(value) / 10.0;
    }

    /**
     * Returns the used capacity of the battery in milliamp-hours (mAh).
     * The fuel value is extracted from the raw data as a 24-bit integer starting
     * at index 7.
     *
     * @return the used capacity in milliamp-hours.
     */
    public double getFuel() {
        return ByteBuffer.wrap(new byte[]{0, rawData[7], rawData[8], rawData[9]}).getInt();
    }

    /**
     * Returns the estimated remaining battery capacity as a percentage.
     * The remaining value is extracted directly from the raw data at index 10.
     *
     * @return the remaining battery percentage.
     */
    public float getRemaining() {
        return rawData[10];
    }

    /**
     * Indicates that this frame is a telemetry frame.
     * Telemetry frames are used to send data from the aircraft to the ground station.
     *
     * @return {@code true}, indicating that this is a telemetry frame.
     */
    @Override
    public boolean isTelemetry() {
        return true;
    }

}
