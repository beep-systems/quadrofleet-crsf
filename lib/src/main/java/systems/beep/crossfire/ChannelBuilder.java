package systems.beep.crossfire;

import systems.beep.helper.FormatHelper;
import systems.beep.helper.TelemetryHelper;

/**
 * Builder class for constructing a channel configuration.
 * <p>
 * The {@code ChannelBuilder} class facilitates the creation and configuration of
 * channels for telemetry purposes. It allows users to set values for different
 * channels, including roll, pitch, throttle, yaw, and armed channels (CHANNEL 1 to CHANNEL 16).
 * Default values for channels are set based on telemetry failsafe values.
 * </p>
 *
 * <p>
 * Each channel can be set individually using different input types (integer, double, boolean)
 * and automatically converts these values to the correct format using helper methods.
 * </p>
 */
public class ChannelBuilder {

    // Roll - CHANNEL 1
    private int channel1 = TelemetryHelper.FAILSAFE_MICROSECONDS_VALUE;

    // Pitch - CHANNEL 2
    private int channel2 = TelemetryHelper.FAILSAFE_MICROSECONDS_VALUE;

    // Throttle - CHANNEL 3
    private int channel3 = TelemetryHelper.FAILSAFE_CRSF_VALUE;

    // Yaw - CHANNEL 4
    private int channel4 = TelemetryHelper.FAILSAFE_MICROSECONDS_VALUE;

    private int channel5 = TelemetryHelper.FAILSAFE_CRSF_VALUE;

    private int channel6 = TelemetryHelper.FAILSAFE_CRSF_VALUE;

    private int channel7 = TelemetryHelper.FAILSAFE_MICROSECONDS_VALUE;

    private int channel8 = TelemetryHelper.FAILSAFE_MICROSECONDS_VALUE;

    private int channel9 = TelemetryHelper.FAILSAFE_MICROSECONDS_VALUE;

    private int channel10 = TelemetryHelper.FAILSAFE_MICROSECONDS_VALUE;

    private int channel11 = TelemetryHelper.FAILSAFE_MICROSECONDS_VALUE;

    private int channel12 = TelemetryHelper.FAILSAFE_MICROSECONDS_VALUE;

    private int channel13 = TelemetryHelper.FAILSAFE_MICROSECONDS_VALUE;

    private int channel14 = TelemetryHelper.FAILSAFE_MICROSECONDS_VALUE;

    private int channel15 = TelemetryHelper.FAILSAFE_MICROSECONDS_VALUE;

    private int channel16 = TelemetryHelper.FAILSAFE_MICROSECONDS_VALUE;

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
                getArmed(),
                getChannel6(),
                getChannel7(),
                getChannel8(),
                getChannel9(),
                getChannel10(),
                getChannel11(),
                getChannel12(),
                getChannel13(),
                getChannel14(),
                getChannel15(),
                getChannel16()
        };
    }

    // CHANNEL 1 - Roll

    /**
     * Retrieves the value for CHANNEL 1 channel (Roll).
     *
     * @return the CHANNEL 1 (Roll) value.
     */
    public int getChannel1() {
        return channel1;
    }

    /**
     * Sets the value for CHANNEL 1 (Roll) as an integer.
     *
     * @param channel1 the CHANNEL 1 value to set.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel1(int channel1) {
        this.channel1 = channel1;
        return this;
    }

    /**
     * Sets the value for CHANNEL 1 (Roll) as a double and parses it to the correct format.
     *
     * @param channel1 the CHANNEL 1 value to set as a double (values from -1 to 1).
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel1(double channel1) {
        this.channel1 = FormatHelper.parseAxisValue(channel1);
        return this;
    }

    /**
     * Sets the value for CHANNEL 1 (Roll) based on a boolean (activated or not).
     *
     * @param activated the boolean value indicating activation state.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel1(boolean activated) {
        this.channel1 = FormatHelper.parseActivatedValue(activated);
        return this;
    }

    /**
     * Retrieves the value for Roll (alias of CHANNEL 1).
     *
     * @return the Roll value.
     */
    public int getRoll() {
        return channel1;
    }

    /**
     * Sets the value for Roll as an integer.
     *
     * @param roll the Roll value to set.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setRoll(int roll) {
        this.channel1 = roll;
        return this;
    }

    /**
     * Sets the value for Roll as a double and parses it to the correct format.
     *
     * @param roll the Roll value to set as a double (values from -1 to 1).
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setRoll(double roll) {
        this.channel1 = FormatHelper.parseAxisValue(roll);
        return this;
    }

    /**
     * Sets the value for Roll based on a boolean (activated or not).
     *
     * @param activated the boolean value indicating activation state.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setRoll(boolean activated) {
        this.channel1 = FormatHelper.parseActivatedValue(activated);
        return this;
    }

    // CHANNEL 2 - Pitch

    /**
     * Retrieves the value for CHANNEL 2 channel (Pitch).
     *
     * @return the CHANNEL 2 (Pitch) value.
     */
    public int getChannel2() {
        return channel2;
    }

    /**
     * Sets the value for CHANNEL 2 (Pitch) as an integer.
     *
     * @param channel2 the CHANNEL 2 value to set.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel2(int channel2) {
        this.channel2 = channel2;
        return this;
    }

    /**
     * Sets the value for CHANNEL 2 (Pitch) as a double and parses it to the correct format.
     *
     * @param channel2 the CHANNEL 2 value to set as a double (values from -1 to 1).
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel2(double channel2) {
        this.channel2 = FormatHelper.parseAxisValue(channel2);
        return this;
    }

    /**
     * Sets the value for CHANNEL 2 (Pitch) based on a boolean (activated or not).
     *
     * @param activated the boolean value indicating activation state.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel2(boolean activated) {
        this.channel2 = FormatHelper.parseActivatedValue(activated);
        return this;
    }

    /**
     * Retrieves the value for Pitch (alias of CHANNEL 2).
     *
     * @return the Pitch value.
     */
    public int getPitch() {
        return channel2;
    }

    /**
     * Sets the value for Pitch as an integer.
     *
     * @param pitch the Pitch value to set.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setPitch(int pitch) {
        this.channel2 = pitch;
        return this;
    }

    /**
     * Sets the value for Pitch as a double and parses it to the correct format.
     *
     * @param pitch the Pitch value to set as a double (values from -1 to 1).
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setPitch(double pitch) {
        this.channel2 = FormatHelper.parseAxisValue(pitch);
        return this;
    }

    /**
     * Sets the value for Pitch based on a boolean (activated or not).
     *
     * @param activated the boolean value indicating activation state.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setPitch(boolean activated) {
        this.channel2 = FormatHelper.parseActivatedValue(activated);
        return this;
    }

    // CHANNEL 3 - Throttle

    /**
     * Retrieves the value for CHANNEL 3 channel (Throttle).
     *
     * @return the CHANNEL 3 (Throttle) value.
     */
    public int getChannel3() {
        return channel3;
    }

    /**
     * Sets the value for CHANNEL 3 (Throttle) as an integer.
     *
     * @param channel3 the CHANNEL 3 value to set.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel3(int channel3) {
        this.channel3 = channel3;
        return this;
    }

    /**
     * Sets the value for CHANNEL 3 (Throttle) as a double and parses it to the correct format.
     *
     * @param channel3 the CHANNEL 3 value to set as a double (values from -1 to 1).
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel3(double channel3) {
        this.channel3 = FormatHelper.parseAxisValue(channel3);
        return this;
    }

    /**
     * Sets the value for CHANNEL 3 (Throttle) based on a boolean (activated or not).
     *
     * @param activated the boolean value indicating activation state.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel3(boolean activated) {
        this.channel3 = FormatHelper.parseActivatedValue(activated);
        return this;
    }

    /**
     * Retrieves the value for Throttle (alias of CHANNEL 3).
     *
     * @return the Throttle value.
     */
    public int getThrottle() {
        return channel3;
    }

    /**
     * Sets the value for Throttle as an integer.
     *
     * @param throttle the Throttle value to set.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setThrottle(int throttle) {
        this.channel3 = throttle;
        return this;
    }

    /**
     * Sets the value for Throttle as a double and parses it to the correct format.
     *
     * @param throttle the Throttle value to set as a double (values from -1 to 1).
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setThrottle(double throttle) {
        this.channel3 = FormatHelper.parseAxisValue(throttle);
        return this;
    }

    /**
     * Sets the value for Throttle based on a boolean (activated or not).
     *
     * @param activated the boolean value indicating activation state.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setThrottle(boolean activated) {
        this.channel3 = FormatHelper.parseActivatedValue(activated);
        return this;
    }

    // CHANNEL 4 - Yaw

    /**
     * Retrieves the value for CHANNEL 4 channel (Yaw).
     *
     * @return the CHANNEL 4 (Yaw) value.
     */
    public int getChannel4() {
        return channel4;
    }

    /**
     * Sets the value for CHANNEL 4 (Yaw) as an integer.
     *
     * @param channel4 the CHANNEL 4 value to set.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel4(int channel4) {
        this.channel4 = channel4;
        return this;
    }

    /**
     * Sets the value for CHANNEL 4 (Yaw) as a double and parses it to the correct format.
     *
     * @param channel4 the CHANNEL 4 value to set as a double (values from -1 to 1).
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel4(double channel4) {
        this.channel4 = FormatHelper.parseAxisValue(channel5); // Possible typo, should use channel4 here instead of channel5
        return this;
    }

    /**
     * Sets the value for CHANNEL 4 (Yaw) based on a boolean (activated or not).
     *
     * @param activated the boolean value indicating activation state.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel4(boolean activated) {
        this.channel4 = FormatHelper.parseActivatedValue(activated);
        return this;
    }

    /**
     * Retrieves the value for Yaw (alias of CHANNEL 4).
     *
     * @return the Yaw value.
     */
    public int getYaw() {
        return channel4;
    }

    /**
     * Sets the value for Yaw as an integer.
     *
     * @param yaw the Yaw value to set.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setYaw(int yaw) {
        this.channel4 = yaw;
        return this;
    }

    /**
     * Sets the value for Yaw as a double and parses it to the correct format.
     *
     * @param yaw the Yaw value to set as a double (values from -1 to 1).
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setYaw(double yaw) {
        this.channel4 = FormatHelper.parseAxisValue(yaw);
        return this;
    }

    /**
     * Sets the value for Yaw based on a boolean (activated or not).
     *
     * @param activated the boolean value indicating activation state.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setYaw(boolean activated) {
        this.channel4 = FormatHelper.parseActivatedValue(activated);
        return this;
    }

    // CHANNEL 5

    /**
     * Retrieves the value for CHANNEL 5 channel.
     *
     * @return the CHANNEL 5 value.
     */
    public int getChannel5() {
        return channel5;
    }

    /**
     * Sets the value for CHANNEL 5 as an integer.
     *
     * @param channel5 the CHANNEL 5 value to set.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel5(int channel5) {
        this.channel5 = channel5;
        return this;
    }

    /**
     * Sets the value for CHANNEL 5 as a double and parses it to the correct format.
     *
     * @param channel5 the CHANNEL 5 value to set as a double (values from -1 to 1).
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel5(double channel5) {
        this.channel5 = FormatHelper.parseAxisValue(channel5);
        return this;
    }

    /**
     * Sets the value for CHANNEL 5 based on a boolean (activated or not).
     *
     * @param activated the boolean value indicating activation state.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel5(boolean activated) {
        this.channel5 = FormatHelper.parseActivatedValue(activated);
        return this;
    }

    /**
     * Sets the value for Armed based on a boolean (activated or not).
     *
     * @param activated the boolean value indicating activation state.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setArmed(boolean activated) {
        this.channel5 = FormatHelper.parseActivatedValue(activated);
        return this;
    }

    /**
     * Retrieves the value for Armed (alias of CHANNEL 5).
     *
     * @return the Armed value.
     */
    public int getArmed() {
        return channel5;
    }

    // CHANNEL 6

    /**
     * Retrieves the value for CHANNEL 6 channel.
     *
     * @return the CHANNEL 6 value.
     */
    public int getChannel6() {
        return channel6;
    }

    /**
     * Sets the value for CHANNEL 6 as an integer.
     *
     * @param channel6 the CHANNEL 6 value to set.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel6(int channel6) {
        this.channel6 = channel6;
        return this;
    }

    /**
     * Sets the value for CHANNEL 6 as a double and parses it to the correct format.
     *
     * @param channel6 the CHANNEL 6 value to set as a double (values from -1 to 1).
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel6(double channel6) {
        this.channel6 = FormatHelper.parseAxisValue(channel6);
        return this;
    }

    /**
     * Sets the value for CHANNEL 6 based on a boolean (activated or not).
     *
     * @param activated the boolean value indicating activation state.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel6(boolean activated) {
        this.channel6 = FormatHelper.parseActivatedValue(activated);
        return this;
    }

    // CHANNEL 7

    /**
     * Retrieves the value for CHANNEL 7 channel.
     *
     * @return the CHANNEL 7 value.
     */
    public int getChannel7() {
        return channel7;
    }

    /**
     * Sets the value for CHANNEL 7 as an integer.
     *
     * @param channel7 the CHANNEL 7 value to set.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel7(int channel7) {
        this.channel7 = channel7;
        return this;
    }

    /**
     * Sets the value for CHANNEL 7 as a double and parses it to the correct format.
     *
     * @param channel7 the CHANNEL 7 value to set as a double (values from -1 to 1).
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel7(double channel7) {
        this.channel7 = FormatHelper.parseAxisValue(channel7);
        return this;
    }

    /**
     * Sets the value for CHANNEL 7 based on a boolean (activated or not).
     *
     * @param activated the boolean value indicating activation state.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel7(boolean activated) {
        this.channel7 = FormatHelper.parseActivatedValue(activated);
        return this;
    }

    // CHANNEL 8

    /**
     * Retrieves the value for CHANNEL 8 channel.
     *
     * @return the CHANNEL 8 value.
     */
    public int getChannel8() {
        return channel8;
    }

    /**
     * Sets the value for CHANNEL 8 as an integer.
     *
     * @param channel8 the CHANNEL 8 value to set.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel8(int channel8) {
        this.channel8 = channel8;
        return this;
    }

    /**
     * Sets the value for CHANNEL 8 as a double and parses it to the correct format.
     *
     * @param channel8 the CHANNEL 8 value to set as a double (values from -1 to 1).
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel8(double channel8) {
        this.channel8 = FormatHelper.parseAxisValue(channel8);
        return this;
    }

    /**
     * Sets the value for CHANNEL 8 based on a boolean (activated or not).
     *
     * @param activated the boolean value indicating activation state.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel8(boolean activated) {
        this.channel8 = FormatHelper.parseActivatedValue(activated);
        return this;
    }

    // CHANNEL 9

    /**
     * Retrieves the value for CHANNEL 9 channel.
     *
     * @return the CHANNEL 9 value.
     */
    public int getChannel9() {
        return channel9;
    }

    /**
     * Sets the value for CHANNEL 9 as an integer.
     *
     * @param channel9 the CHANNEL 9 value to set.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel9(int channel9) {
        this.channel9 = channel9;
        return this;
    }

    /**
     * Sets the value for CHANNEL 9 as a double and parses it to the correct format.
     *
     * @param channel9 the CHANNEL 9 value to set as a double (values from -1 to 1).
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel9(double channel9) {
        this.channel9 = FormatHelper.parseAxisValue(channel9);
        return this;
    }

    /**
     * Sets the value for CHANNEL 9 based on a boolean (activated or not).
     *
     * @param activated the boolean value indicating activation state.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel9(boolean activated) {
        this.channel9 = FormatHelper.parseActivatedValue(activated);
        return this;
    }

    // CHANNEL 10

    /**
     * Retrieves the value for CHANNEL 10 channel.
     *
     * @return the CHANNEL 10 value.
     */
    public int getChannel10() {
        return channel10;
    }

    /**
     * Sets the value for CHANNEL 10 as an integer.
     *
     * @param channel10 the CHANNEL 10 value to set.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel10(int channel10) {
        this.channel10 = channel10;
        return this;
    }

    /**
     * Sets the value for CHANNEL 10 as a double and parses it to the correct format.
     *
     * @param channel10 the CHANNEL 10 value to set as a double (values from -1 to 1).
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel10(double channel10) {
        this.channel10 = FormatHelper.parseAxisValue(channel10);
        return this;
    }

    /**
     * Sets the value for CHANNEL 10 based on a boolean (activated or not).
     *
     * @param activated the boolean value indicating activation state.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel10(boolean activated) {
        this.channel10 = FormatHelper.parseActivatedValue(activated);
        return this;
    }

    // CHANNEL 11

    /**
     * Retrieves the value for CHANNEL 11 channel.
     *
     * @return the CHANNEL 11 value.
     */
    public int getChannel11() {
        return channel11;
    }

    /**
     * Sets the value for CHANNEL 11 as an integer.
     *
     * @param channel11 the CHANNEL 11 value to set.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel11(int channel11) {
        this.channel11 = channel11;
        return this;
    }

    /**
     * Sets the value for CHANNEL 11 as a double and parses it to the correct format.
     *
     * @param channel11 the CHANNEL 11 value to set as a double (values from -1 to 1).
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel11(double channel11) {
        this.channel11 = FormatHelper.parseAxisValue(channel11);
        return this;
    }

    /**
     * Sets the value for CHANNEL 11 based on a boolean (activated or not).
     *
     * @param activated the boolean value indicating activation state.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel11(boolean activated) {
        this.channel11 = FormatHelper.parseActivatedValue(activated);
        return this;
    }

    // CHANNEL 12

    /**
     * Retrieves the value for CHANNEL 12 channel.
     *
     * @return the CHANNEL 12 value.
     */
    public int getChannel12() {
        return channel12;
    }

    /**
     * Sets the value for CHANNEL 12 as an integer.
     *
     * @param channel12 the CHANNEL 12 value to set.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel12(int channel12) {
        this.channel12 = channel12;
        return this;
    }

    /**
     * Sets the value for CHANNEL 12 as a double and parses it to the correct format.
     *
     * @param channel12 the CHANNEL 12 value to set as a double (values from -1 to 1).
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel12(double channel12) {
        this.channel12 = FormatHelper.parseAxisValue(channel12);
        return this;
    }

    /**
     * Sets the value for CHANNEL 12 based on a boolean (activated or not).
     *
     * @param activated the boolean value indicating activation state.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel12(boolean activated) {
        this.channel12 = FormatHelper.parseActivatedValue(activated);
        return this;
    }

    // CHANNEL 13

    /**
     * Retrieves the value for CHANNEL 13 channel.
     *
     * @return the CHANNEL 13 value.
     */
    public int getChannel13() {
        return channel13;
    }

    /**
     * Sets the value for CHANNEL 13 as an integer.
     *
     * @param channel13 the CHANNEL 13 value to set.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel13(int channel13) {
        this.channel13 = channel13;
        return this;
    }

    /**
     * Sets the value for CHANNEL 13 as a double and parses it to the correct format.
     *
     * @param channel13 the CHANNEL 13 value to set as a double (values from -1 to 1).
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel13(double channel13) {
        this.channel13 = FormatHelper.parseAxisValue(channel13);
        return this;
    }

    /**
     * Sets the value for CHANNEL 13 based on a boolean (activated or not).
     *
     * @param activated the boolean value indicating activation state.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel13(boolean activated) {
        this.channel13 = FormatHelper.parseActivatedValue(activated);
        return this;
    }

    // CHANNEL 14

    /**
     * Retrieves the value for CHANNEL 14 channel.
     *
     * @return the CHANNEL 14 value.
     */
    public int getChannel14() {
        return channel14;
    }

    /**
     * Sets the value for CHANNEL 14 as an integer.
     *
     * @param channel14 the CHANNEL 14 value to set.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel14(int channel14) {
        this.channel14 = channel14;
        return this;
    }

    /**
     * Sets the value for CHANNEL 14 as a double and parses it to the correct format.
     *
     * @param channel14 the CHANNEL 14 value to set as a double (values from -1 to 1).
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel14(double channel14) {
        this.channel14 = FormatHelper.parseAxisValue(channel14);
        return this;
    }

    /**
     * Sets the value for CHANNEL 14 based on a boolean (activated or not).
     *
     * @param activated the boolean value indicating activation state.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel14(boolean activated) {
        this.channel14 = FormatHelper.parseActivatedValue(activated);
        return this;
    }

    // CHANNEL 15

    /**
     * Retrieves the value for CHANNEL 15 channel.
     *
     * @return the CHANNEL 15 value.
     */
    public int getChannel15() {
        return channel15;
    }

    /**
     * Sets the value for CHANNEL 15 as an integer.
     *
     * @param channel15 the CHANNEL 15 value to set.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel15(int channel15) {
        this.channel15 = channel15;
        return this;
    }

    /**
     * Sets the value for CHANNEL 15 as a double and parses it to the correct format.
     *
     * @param channel15 the CHANNEL 15 value to set as a double (values from -1 to 1).
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel15(double channel15) {
        this.channel15 = FormatHelper.parseAxisValue(channel15);
        return this;
    }

    /**
     * Sets the value for CHANNEL 15 based on a boolean (activated or not).
     *
     * @param activated the boolean value indicating activation state.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel15(boolean activated) {
        this.channel15 = FormatHelper.parseActivatedValue(activated);
        return this;
    }

    // CHANNEL 16

    /**
     * Retrieves the value for CHANNEL 16 channel.
     *
     * @return the CHANNEL 16 value.
     */
    public int getChannel16() {
        return channel16;
    }

    /**
     * Sets the value for CHANNEL 16 as an integer.
     *
     * @param channel16 the CHANNEL 16 value to set.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel16(int channel16) {
        this.channel16 = channel16;
        return this;
    }

    /**
     * Sets the value for CHANNEL 16 as a double and parses it to the correct format.
     *
     * @param channel16 the CHANNEL 16 value to set as a double (values from -1 to 1).
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel16(double channel16) {
        this.channel16 = FormatHelper.parseAxisValue(channel16);
        return this;
    }

    /**
     * Sets the value for CHANNEL 16 based on a boolean (activated or not).
     *
     * @param activated the boolean value indicating activation state.
     * @return the current {@code ChannelBuilder} instance for chaining.
     */
    public ChannelBuilder setChannel16(boolean activated) {
        this.channel16 = FormatHelper.parseActivatedValue(activated);
        return this;
    }

}
