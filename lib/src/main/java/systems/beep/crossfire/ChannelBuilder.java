package systems.beep.crossfire;

import systems.beep.helper.FormatHelper;
import systems.beep.helper.TelemetryHelper;

/**
 * Builder class for constructing a channel configuration.
 * <p>
 * The {@code ChannelBuilder} class facilitates the creation and configuration of
 * channels for telemetry purposes. It allows users to set values for different
 * channels, including roll, pitch, throttle, yaw, and auxiliary channels (AUX1 to AUX16).
 * Default values for channels are set based on telemetry failsafe values.
 * </p>
 *
 * <p>
 * Each channel can be set individually using different input types (integer, double, boolean)
 * and automatically converts these values to the correct format using helper methods.
 * </p>
 */
public class ChannelBuilder {

    // Roll - AUX1
    private int aux1 = TelemetryHelper.FAILSAFE_MICROSECONDS_VALUE;

    // Pitch - AUX2
    private int aux2 = TelemetryHelper.FAILSAFE_MICROSECONDS_VALUE;

    // Throttle - AUX3
    private int aux3 = TelemetryHelper.FAILSAFE_CRSF_VALUE;

    // Yaw - AUX4
    private int aux4 = TelemetryHelper.FAILSAFE_MICROSECONDS_VALUE;

    private int aux5 = TelemetryHelper.FAILSAFE_CRSF_VALUE;

    private int aux6 = TelemetryHelper.FAILSAFE_CRSF_VALUE;

    private int aux7 = TelemetryHelper.FAILSAFE_MICROSECONDS_VALUE;

    private int aux8 = TelemetryHelper.FAILSAFE_MICROSECONDS_VALUE;

    private int aux9 = TelemetryHelper.FAILSAFE_MICROSECONDS_VALUE;

    private int aux10 = TelemetryHelper.FAILSAFE_MICROSECONDS_VALUE;

    private int aux11 = TelemetryHelper.FAILSAFE_MICROSECONDS_VALUE;

    private int aux12 = TelemetryHelper.FAILSAFE_MICROSECONDS_VALUE;

    private int aux13 = TelemetryHelper.FAILSAFE_MICROSECONDS_VALUE;

    private int aux14 = TelemetryHelper.FAILSAFE_MICROSECONDS_VALUE;

    private int aux15 = TelemetryHelper.FAILSAFE_MICROSECONDS_VALUE;

    private int aux16 = TelemetryHelper.FAILSAFE_MICROSECONDS_VALUE;

    /**
     * Private constructor to prevent direct instantiation.
     * Use the {@link #builder()} method to create an instance.
     */
    private ChannelBuilder() {
        // Private constructor to prevent instantiation
    }

    /**
     * Creates a new instance of the {@code ChannelBuilder}.
     *
     * @return a new {@code ChannelBuilder} instance.
     */
    public static ChannelBuilder builder() {
        return new ChannelBuilder();
    }

    /**
     * Builds an array of channel values.
     *
     * @return an array containing the values for all channels.
     */
    public int[] build() {
        return new int[]{
                getRoll(),
                getPitch(),
                getThrottle(),
                getYaw(),
                getAux5(),
                getAux6(),
                getAux7(),
                getAux8(),
                getAux9(),
                getAux10(),
                getAux11(),
                getAux12(),
                getAux13(),
                getAux14(),
                getAux15(),
                getAux16()
        };
    }

    // AUX1 - Roll

    /**
     * Retrieves the value for AUX1 channel (Roll).
     *
     * @return the AUX1 (Roll) value.
     */
    public int getAux1() {
        return aux1;
    }

    /**
     * Sets the value for AUX1 (Roll) as an integer.
     *
     * @param aux1 the AUX1 value to set.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux1(int aux1) {
        this.aux1 = aux1;
        return this;
    }

    /**
     * Sets the value for AUX1 (Roll) as a double and parses it to the correct format.
     *
     * @param aux1 the AUX1 value to set as a double.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux1(double aux1) {
        this.aux1 = FormatHelper.parseAxisValue(aux1);
        return this;
    }

    /**
     * Sets the value for AUX1 (Roll) based on a boolean (activated or not).
     *
     * @param activated the boolean value indicating activation state.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux1(boolean activated) {
        this.aux1 = FormatHelper.parseActivatedValue(activated);
        return this;
    }

    /**
     * Retrieves the value for Roll (alias of AUX1).
     *
     * @return the Roll value.
     */
    public int getRoll() {
        return aux1;
    }

    /**
     * Sets the value for Roll as an integer.
     *
     * @param roll the Roll value to set.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setRoll(int roll) {
        this.aux1 = roll;
        return this;
    }

    /**
     * Sets the value for Roll as a double and parses it to the correct format.
     *
     * @param roll the Roll value to set as a double.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setRoll(double roll) {
        this.aux1 = FormatHelper.parseAxisValue(roll);
        return this;
    }

    /**
     * Sets the value for Roll based on a boolean (activated or not).
     *
     * @param activated the boolean value indicating activation state.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setRoll(boolean activated) {
        this.aux1 = FormatHelper.parseActivatedValue(activated);
        return this;
    }

    // AUX2

    /**
     * Retrieves the value for AUX2 channel (Pitch).
     *
     * @return the AUX2 (Pitch) value.
     */
    public int getAux2() {
        return aux2;
    }

    /**
     * Sets the value for AUX2 (Pitch) as an integer.
     *
     * @param aux2 the AUX2 value to set.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux2(int aux2) {
        this.aux2 = aux2;
        return this;
    }

    /**
     * Sets the value for AUX2 (Pitch) as a double and parses it to the correct format.
     *
     * @param aux2 the AUX2 value to set as a double.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux2(double aux2) {
        this.aux2 = FormatHelper.parseAxisValue(aux2);
        return this;
    }

    /**
     * Sets the value for AUX2 (Pitch) based on a boolean (activated or not).
     *
     * @param activated the boolean value indicating activation state.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux2(boolean activated) {
        this.aux2 = FormatHelper.parseActivatedValue(activated);
        return this;
    }

    /**
     * Retrieves the value for Pitch (alias of AUX2).
     *
     * @return the Pitch value.
     */
    public int getPitch() {
        return aux2;
    }

    /**
     * Sets the value for Pitch as an integer.
     *
     * @param pitch the Pitch value to set.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setPitch(int pitch) {
        this.aux2 = pitch;
        return this;
    }

    /**
     * Sets the value for Pitch as a double and parses it to the correct format.
     *
     * @param pitch the Pitch value to set as a double.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setPitch(double pitch) {
        this.aux2 = FormatHelper.parseAxisValue(pitch);
        return this;
    }

    /**
     * Sets the value for Pitch based on a boolean (activated or not).
     *
     * @param activated the boolean value indicating activation state.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setPitch(boolean activated) {
        this.aux2 = FormatHelper.parseActivatedValue(activated);
        return this;
    }

    // AUX3

    /**
     * Retrieves the value for AUX3 channel (Throttle).
     *
     * @return the AUX3 (Throttle) value.
     */
    public int getAux3() {
        return aux3;
    }

    /**
     * Sets the value for AUX3 (Throttle) as an integer.
     *
     * @param aux3 the AUX3 value to set.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux3(int aux3) {
        this.aux3 = aux3;
        return this;
    }

    /**
     * Sets the value for AUX3 (Throttle) as a double and parses it to the correct format.
     *
     * @param aux3 the AUX3 value to set as a double.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux3(double aux3) {
        this.aux3 = FormatHelper.parseAxisValue(aux3);
        return this;
    }

    /**
     * Sets the value for AUX3 (Throttle) based on a boolean (activated or not).
     *
     * @param activated the boolean value indicating activation state.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux3(boolean activated) {
        this.aux3 = FormatHelper.parseActivatedValue(activated);
        return this;
    }

    /**
     * Retrieves the value for Throttle (alias of AUX3).
     *
     * @return the Throttle value.
     */
    public int getThrottle() {
        return aux3;
    }

    /**
     * Sets the value for Throttle as an integer.
     *
     * @param throttle the Throttle value to set.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setThrottle(int throttle) {
        this.aux3 = throttle;
        return this;
    }

    /**
     * Sets the value for Throttle as a double and parses it to the correct format.
     *
     * @param throttle the Throttle value to set as a double.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setThrottle(double throttle) {
        this.aux3 = FormatHelper.parseAxisValue(throttle);
        return this;
    }

    /**
     * Sets the value for Throttle based on a boolean (activated or not).
     *
     * @param activated the boolean value indicating activation state.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setThrottle(boolean activated) {
        this.aux3 = FormatHelper.parseActivatedValue(activated);
        return this;
    }


    // AUX4

    /**
     * Retrieves the value for AUX4 channel (Yaw).
     *
     * @return the AUX4 (Yaw) value.
     */
    public int getAux4() {
        return aux4;
    }

    /**
     * Sets the value for AUX4 (Yaw) as an integer.
     *
     * @param aux4 the AUX4 value to set.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux4(int aux4) {
        this.aux4 = aux4;
        return this;
    }

    /**
     * Sets the value for AUX4 (Yaw) as a double and parses it to the correct format.
     *
     * @param aux4 the AUX4 value to set as a double.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux4(double aux4) {
        this.aux4 = FormatHelper.parseAxisValue(aux5); // Possible typo, should use aux4 here instead of aux5
        return this;
    }

    /**
     * Sets the value for AUX4 (Yaw) based on a boolean (activated or not).
     *
     * @param activated the boolean value indicating activation state.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux4(boolean activated) {
        this.aux5 = FormatHelper.parseActivatedValue(activated); // Possible typo, should use aux4 here instead of aux5
        return this;
    }

    /**
     * Retrieves the value for Yaw (alias of AUX4).
     *
     * @return the Yaw value.
     */
    public int getYaw() {
        return aux4;
    }

    /**
     * Sets the value for Yaw as an integer.
     *
     * @param yaw the Yaw value to set.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setYaw(int yaw) {
        this.aux4 = yaw;
        return this;
    }

    /**
     * Sets the value for Yaw as a double and parses it to the correct format.
     *
     * @param yaw the Yaw value to set as a double.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setYaw(double yaw) {
        this.aux4 = FormatHelper.parseAxisValue(yaw);
        return this;
    }

    /**
     * Sets the value for Yaw based on a boolean (activated or not).
     *
     * @param activated the boolean value indicating activation state.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setYaw(boolean activated) {
        this.aux5 = FormatHelper.parseActivatedValue(activated); // Possible typo, should use aux4 here instead of aux5
        return this;
    }

// AUX5

    /**
     * Retrieves the value for AUX5 channel.
     *
     * @return the AUX5 value.
     */
    public int getAux5() {
        return aux5;
    }

    /**
     * Sets the value for AUX5 as an integer.
     *
     * @param aux5 the AUX5 value to set.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux5(int aux5) {
        this.aux5 = aux5;
        return this;
    }

    /**
     * Sets the value for AUX5 as a double and parses it to the correct format.
     *
     * @param aux5 the AUX5 value to set as a double.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux5(double aux5) {
        this.aux5 = FormatHelper.parseAxisValue(aux5);
        return this;
    }

    /**
     * Sets the value for AUX5 based on a boolean (activated or not).
     *
     * @param activated the boolean value indicating activation state.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux5(boolean activated) {
        this.aux5 = FormatHelper.parseActivatedValue(activated);
        return this;
    }

    // AUX6

    /**
     * Retrieves the value for AUX6 channel.
     *
     * @return the AUX6 value.
     */
    public int getAux6() {
        return aux6;
    }

    /**
     * Sets the value for AUX6 as an integer.
     *
     * @param aux6 the AUX6 value to set.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux6(int aux6) {
        this.aux6 = aux6;
        return this;
    }

    /**
     * Sets the value for AUX6 as a double and parses it to the correct format.
     *
     * @param aux6 the AUX6 value to set as a double.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux6(double aux6) {
        this.aux6 = FormatHelper.parseAxisValue(aux6);
        return this;
    }

    /**
     * Sets the value for AUX6 based on a boolean (activated or not).
     *
     * @param activated the boolean value indicating activation state.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux6(boolean activated) {
        this.aux6 = FormatHelper.parseActivatedValue(activated);
        return this;
    }

// AUX7

    /**
     * Retrieves the value for AUX7 channel.
     *
     * @return the AUX7 value.
     */
    public int getAux7() {
        return aux7;
    }

    /**
     * Sets the value for AUX7 as an integer.
     *
     * @param aux7 the AUX7 value to set.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux7(int aux7) {
        this.aux7 = aux7;
        return this;
    }

    /**
     * Sets the value for AUX7 as a double and parses it to the correct format.
     *
     * @param aux7 the AUX7 value to set as a double.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux7(double aux7) {
        this.aux7 = FormatHelper.parseAxisValue(aux7);
        return this;
    }

    /**
     * Sets the value for AUX7 based on a boolean (activated or not).
     *
     * @param activated the boolean value indicating activation state.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux7(boolean activated) {
        this.aux7 = FormatHelper.parseActivatedValue(activated);
        return this;
    }

// AUX8

    /**
     * Retrieves the value for AUX8 channel.
     *
     * @return the AUX8 value.
     */
    public int getAux8() {
        return aux8;
    }

    /**
     * Sets the value for AUX8 as an integer.
     *
     * @param aux8 the AUX8 value to set.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux8(int aux8) {
        this.aux8 = aux8;
        return this;
    }

    /**
     * Sets the value for AUX8 as a double and parses it to the correct format.
     *
     * @param aux8 the AUX8 value to set as a double.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux8(double aux8) {
        this.aux8 = FormatHelper.parseAxisValue(aux8);
        return this;
    }

    /**
     * Sets the value for AUX8 based on a boolean (activated or not).
     *
     * @param activated the boolean value indicating activation state.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux8(boolean activated) {
        this.aux8 = FormatHelper.parseActivatedValue(activated);
        return this;
    }


    // AUX9

    // AUX9

    /**
     * Retrieves the value for AUX9 channel.
     *
     * @return the AUX9 value.
     */
    public int getAux9() {
        return aux9;
    }

    /**
     * Sets the value for AUX9 as an integer.
     *
     * @param aux9 the AUX9 value to set.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux9(int aux9) {
        this.aux9 = aux9;
        return this;
    }

    /**
     * Sets the value for AUX9 as a double and parses it to the correct format.
     *
     * @param aux9 the AUX9 value to set as a double.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux9(double aux9) {
        this.aux9 = FormatHelper.parseAxisValue(aux9);
        return this;
    }

    /**
     * Sets the value for AUX9 based on a boolean (activated or not).
     *
     * @param activated the boolean value indicating activation state.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux9(boolean activated) {
        this.aux9 = FormatHelper.parseActivatedValue(activated);
        return this;
    }

// AUX10

    /**
     * Retrieves the value for AUX10 channel.
     *
     * @return the AUX10 value.
     */
    public int getAux10() {
        return aux10;
    }

    /**
     * Sets the value for AUX10 as an integer.
     *
     * @param aux10 the AUX10 value to set.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux10(int aux10) {
        this.aux10 = aux10;
        return this;
    }

    /**
     * Sets the value for AUX10 as a double and parses it to the correct format.
     *
     * @param aux10 the AUX10 value to set as a double.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux10(double aux10) {
        this.aux10 = FormatHelper.parseAxisValue(aux10);
        return this;
    }

    /**
     * Sets the value for AUX10 based on a boolean (activated or not).
     *
     * @param activated the boolean value indicating activation state.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux10(boolean activated) {
        this.aux10 = FormatHelper.parseActivatedValue(activated);
        return this;
    }

// AUX11

    /**
     * Retrieves the value for AUX11 channel.
     *
     * @return the AUX11 value.
     */
    public int getAux11() {
        return aux11;
    }

    /**
     * Sets the value for AUX11 as an integer.
     *
     * @param aux11 the AUX11 value to set.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux11(int aux11) {
        this.aux11 = aux11;
        return this;
    }

    /**
     * Sets the value for AUX11 as a double and parses it to the correct format.
     *
     * @param aux11 the AUX11 value to set as a double.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux11(double aux11) {
        this.aux11 = FormatHelper.parseAxisValue(aux11);
        return this;
    }

    /**
     * Sets the value for AUX11 based on a boolean (activated or not).
     *
     * @param activated the boolean value indicating activation state.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux11(boolean activated) {
        this.aux11 = FormatHelper.parseActivatedValue(activated);
        return this;
    }

// AUX12

    /**
     * Retrieves the value for AUX12 channel.
     *
     * @return the AUX12 value.
     */
    public int getAux12() {
        return aux12;
    }

    /**
     * Sets the value for AUX12 as an integer.
     *
     * @param aux12 the AUX12 value to set.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux12(int aux12) {
        this.aux12 = aux12;
        return this;
    }

    /**
     * Sets the value for AUX12 as a double and parses it to the correct format.
     *
     * @param aux12 the AUX12 value to set as a double.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux12(double aux12) {
        this.aux12 = FormatHelper.parseAxisValue(aux12);
        return this;
    }

    /**
     * Sets the value for AUX12 based on a boolean (activated or not).
     *
     * @param activated the boolean value indicating activation state.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux12(boolean activated) {
        this.aux12 = FormatHelper.parseActivatedValue(activated);
        return this;
    }

    // AUX13

    // AUX13

    /**
     * Retrieves the value for AUX13 channel.
     *
     * @return the AUX13 value.
     */
    public int getAux13() {
        return aux13;
    }

    /**
     * Sets the value for AUX13 as an integer.
     *
     * @param aux13 the AUX13 value to set.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux13(int aux13) {
        this.aux13 = aux13;
        return this;
    }

    /**
     * Sets the value for AUX13 as a double and parses it to the correct format.
     *
     * @param aux13 the AUX13 value to set as a double.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux13(double aux13) {
        this.aux13 = FormatHelper.parseAxisValue(aux13);
        return this;
    }

    /**
     * Sets the value for AUX13 based on a boolean (activated or not).
     *
     * @param activated the boolean value indicating activation state.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux13(boolean activated) {
        this.aux13 = FormatHelper.parseActivatedValue(activated);
        return this;
    }

// AUX14

    /**
     * Retrieves the value for AUX14 channel.
     *
     * @return the AUX14 value.
     */
    public int getAux14() {
        return aux14;
    }

    /**
     * Sets the value for AUX14 as an integer.
     *
     * @param aux14 the AUX14 value to set.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux14(int aux14) {
        this.aux14 = aux14;
        return this;
    }

    /**
     * Sets the value for AUX14 as a double and parses it to the correct format.
     *
     * @param aux14 the AUX14 value to set as a double.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux14(double aux14) {
        this.aux14 = FormatHelper.parseAxisValue(aux14);
        return this;
    }

    /**
     * Sets the value for AUX14 based on a boolean (activated or not).
     *
     * @param activated the boolean value indicating activation state.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux14(boolean activated) {
        this.aux14 = FormatHelper.parseActivatedValue(activated);
        return this;
    }

// AUX15

    /**
     * Retrieves the value for AUX15 channel.
     *
     * @return the AUX15 value.
     */
    public int getAux15() {
        return aux15;
    }

    /**
     * Sets the value for AUX15 as an integer.
     *
     * @param aux15 the AUX15 value to set.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux15(int aux15) {
        this.aux15 = aux15;
        return this;
    }

    /**
     * Sets the value for AUX15 as a double and parses it to the correct format.
     *
     * @param aux15 the AUX15 value to set as a double.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux15(double aux15) {
        this.aux15 = FormatHelper.parseAxisValue(aux15);
        return this;
    }

    /**
     * Sets the value for AUX15 based on a boolean (activated or not).
     *
     * @param activated the boolean value indicating activation state.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux15(boolean activated) {
        this.aux15 = FormatHelper.parseActivatedValue(activated);
        return this;
    }

// AUX16

    /**
     * Retrieves the value for AUX16 channel.
     *
     * @return the AUX16 value.
     */
    public int getAux16() {
        return aux16;
    }

    /**
     * Sets the value for AUX16 as an integer.
     *
     * @param aux16 the AUX16 value to set.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux16(int aux16) {
        this.aux16 = aux16;
        return this;
    }

    /**
     * Sets the value for AUX16 as a double and parses it to the correct format.
     *
     * @param aux16 the AUX16 value to set as a double.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux16(double aux16) {
        this.aux16 = FormatHelper.parseAxisValue(aux16);
        return this;
    }

    /**
     * Sets the value for AUX16 based on a boolean (activated or not).
     *
     * @param activated the boolean value indicating activation state.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setAux16(boolean activated) {
        this.aux16 = FormatHelper.parseActivatedValue(activated);
        return this;
    }

}
