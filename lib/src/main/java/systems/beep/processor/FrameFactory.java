package systems.beep.processor;

import systems.beep.crossfire.frame.AttitudeFrame;
import systems.beep.crossfire.frame.BatteryFrame;
import systems.beep.crossfire.frame.CRSFFrame;
import systems.beep.crossfire.frame.ChannelsFrame;
import systems.beep.crossfire.frame.DeviceInfoFrame;
import systems.beep.crossfire.frame.FlightModeFrame;
import systems.beep.crossfire.frame.GPSFrame;
import systems.beep.crossfire.frame.HexFrame;
import systems.beep.crossfire.frame.LinkStatisticsFrame;
import systems.beep.crossfire.frame.OpenTxSyncFrame;
import systems.beep.crossfire.frame.VariometerFrame;
import systems.beep.crossfire.frame.sub.FrameType;
import systems.beep.exception.IncorrectFrameTypeException;

import java.util.Arrays;

/**
 * Factory class for generating CRSF (Crossfire) frames based on incoming data.
 * <p>
 * The {@code FrameFactory} class encapsulates the logic to create specific
 * frame types from raw byte data. It identifies the type of frame to be
 * created using the third byte of the data array and instantiates the
 * corresponding frame class.
 * </p>
 */
public class FrameFactory {

    /**
     * Generates a {@link CRSFFrame} instance based on the provided byte array.
     * <p>
     * This method inspects the third byte of the provided data to determine
     * the frame type and creates the corresponding frame class instance.
     * If the frame type cannot be determined, it throws an {@link IncorrectFrameTypeException}.
     * </p>
     *
     * @param data the byte array containing raw frame data. Must not be null and must contain at least 3 bytes.
     * @return an instance of a specific frame type corresponding to the provided data.
     * @throws IncorrectFrameTypeException if the frame type cannot be determined from the provided data.
     */
    public static CRSFFrame generateFrame(byte[] data) {
        if (data == null || data.length < 3) {
            return null;
        }

        FrameType frameType = Arrays.stream(FrameType.values())
                .filter(item -> item.getValue() == data[2])
                .findAny()
                .orElseThrow(IncorrectFrameTypeException::new);

        return switch (frameType) {
            case DEVICE_INFO -> new DeviceInfoFrame(data);
            case RADIO_ID -> new OpenTxSyncFrame(data);
            case ATTITUDE -> new AttitudeFrame(data);
            case LINK_LINK_STATISTICS -> new LinkStatisticsFrame(data);
            case FLIGHT_MODE -> new FlightModeFrame(data);
            case BATTERY_SENSOR -> new BatteryFrame(data);
            case RC_CHANNELS_PACKED -> new ChannelsFrame(data);
            case VARIO -> new VariometerFrame(data);
            case GPS -> new GPSFrame(data);
            default -> new HexFrame(data);
        };
    }

}
