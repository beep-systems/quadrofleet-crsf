# CRSF Protocol Java Library

A Java library for implementing the Crossfire (CRSF) protocol, designed for reliable and low-latency communication in remote control systems. The CRSF protocol is commonly used in radio control systems for unmanned aerial vehicles (UAVs) and other remote-controlled devices, providing fast and secure data transmission.

## Features

- **Crossfire (CRSF) Protocol Support**: Implements core functionalities for sending and receiving CRSF messages, including frame processing, telemetry, and error handling.
- **Low-latency Communication**: Optimized for real-time data transmission with minimal delay, ensuring responsive control for UAVs and remote systems.
- **Reliable Data Transfer**: Supports error detection (CRC validation) and recovery mechanisms to ensure stable and consistent communication.
- **Flexible Integration**: Easy to integrate with existing Java applications and custom projects through an intuitive API.
- **Configurable Packet Handling**: Allows custom processing of incoming and outgoing packets with support for telemetry, RC channels, GPS, and more.
- **Frame Types**: Supports various CRSF frame types like `ChannelsFrame`, `GPSFrame`, `FlightModeFrame`, `LinkStatisticsFrame`, `VariometerFrame`, and more.
- **Telemetry**: Capture and process telemetry data from UAVs, including GPS, altitude, battery status, flight mode, and link statistics.

## Installation

To include the CRSF Protocol Java Library in your project, you can add the following dependency to your `pom.xml` if you are using Maven:

```xml
<dependency>
    <groupId>beep.systems</groupId>
    <artifactId>jcrsf</artifactId>
    <version>0.0.1</version>
</dependency>
```

For Gradle users, add this to your `build.gradle`:

```groovy
implementation 'beep.systems:jcrsf:0.0.1'
```

Alternatively,
you can download the JAR file from the [releases](https://github.com/beep-systems/jcrsf/releases) page and include it manually in your project.

## Usage

Here is a basic example of how to use the CRSF Protocol Java Library to process incoming CRSF frames and handle telemetry data:

```java
import systems.beep.crossfire.frame.CRSFFrame;
import systems.beep.crossfire.frame.GPSFrame;
import systems.beep.processor.FrameProcessor;

import java.util.function.Consumer;

public class CRSFExample {
    public static void main(String[] args) {
        // Create a FrameProcessor to handle incoming data
        FrameProcessor frameProcessor = new FrameProcessor();
        
        // Simulate incoming data
        byte[] rawData = new byte[]{0x10, 0x12, 0x02, 0x00, 0x01, 0x02, 0x03};

        // Process the data and define how frames will be handled
        frameProcessor.processData(rawData, frame -> {
            // Example: Check if the frame is a GPSFrame and print GPS data
            if (frame instanceof GPSFrame gpsFrame) {
                System.out.println("GPS Latitude: " + gpsFrame.getLatitude());
                System.out.println("GPS Longitude: " + gpsFrame.getLongitude());
            }
        });
    }
}
```

### Frame Creation Example

You can also create and build CRSF frames using the provided builders:

```java
import systems.beep.crossfire.frame.ChannelsFrame;
import systems.beep.crossfire.frame.sub.Address;

public class ChannelFrameExample {
    public static void main(String[] args) {
        // Create a ChannelsFrame using the builder
        byte[] channelsFrame = ChannelsFrame.builder()
                .setAddress(Address.CRSF_TRANSMITTER)
                .setChannels(ChannelBuilder.builder()
                        .setArmed(false)
                        .setRoll(0)
                        .setPitch(0)
                        .setThrottle(0)
                        .setYaw(0)
                        .build())
                .build();
        
        // Process or send the frame
        System.out.println(FormatHelper.byteArrayToHexWithSpaces(frame));
    }
}
```

## Project Status

This library is currently in the **early stages of development**. While core functionalities for processing CRSF frames and telemetry data are implemented, some frame types may not yet be fully supported, and there may still be **bugs** or **incomplete features**. We are actively working to improve the library, and contributions are welcome to help enhance its capabilities and stability.

As the project evolves, additional frame types and features will be added. Users should be aware that some functionality might be subject to change or require further testing.


## Documentation

Detailed documentation for the library's classes, methods, and usage can be found [here](https://github.com/beep-systems/jcrsf/wiki). This includes:
- Detailed class and method descriptions (e.g., `FrameProcessor`, `CRSFFrame`, `TelemetryHelper`).
- Usage examples for processing and building different frame types.
- Error handling and CRC checks using `CRCHelper`.

## Contributing

Contributions are welcome! If you would like to contribute to this project, please follow these steps:
1. Fork the repository.
2. Create a new branch for your feature or bugfix.
3. Submit a pull request with a clear explanation of your changes.

## License

This library is licensed under the GPL-3.0 License. See the [LICENSE](https://github.com/beep-systems/jcrsf/blob/master/LICENSE) file for more details.

## Acknowledgements

This project was inspired by various CRSF protocol implementations and adapted specifically for the Java ecosystem.
Thanks to the open-source community for contributions and shared knowledge.

## Useful Links

Here are some useful resources and references that can provide further insight into the CRSF protocol and related implementations:

- [CRSF Protocol Wiki](https://github.com/crsf-wg/crsf/wiki): The official CRSF protocol wiki, offering in-depth documentation on the protocol, frame types, and how it operates.

- [CRSF Rust Implementation](https://github.com/tact1m4n3/crsf-rs): A CRSF protocol implementation in Rust, which can serve as a reference for understanding protocol behavior and frame structures in a different programming language.

- [ExpressLRS CRSF Protocol Source](https://github.com/ExpressLRS/ExpressLRS/blob/master/src/lib/CrsfProtocol/crsf_protocol.h): The CRSF protocol definition used in the ExpressLRS project. This header file defines the protocol's key elements and can be a helpful resource for developers.

- [Betaflight CRSF Protocol Source](https://github.com/betaflight/betaflight/blob/master/src/main/rx/crsf.c): CRSF protocol handling within the Betaflight project, a popular open-source flight control software for UAVs. This source code demonstrates how CRSF is integrated into real-world UAV control systems.
