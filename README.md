# NetworkProgramming Repository

This repository contains Java code samples that cover essential networking concepts, from basic Internet addresses to advanced topics like secure socket communication and Remote Method Invocation (RMI). The repository is organized into units (Unit 2 - Unit 12), each focusing on a specific area of network programming.

## Prerequisites

Before running the code in this repository, ensure you have the following installed:

- **Java Development Kit (JDK)**: Version 8 or higher is recommended. You can download it from [Oracle's website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or use an open-source alternative like [OpenJDK](https://openjdk.java.net/).
- **Java Runtime Environment (JRE)**: Necessary to run Java applications.
- **Keytool**: A command-line utility included with the JDK for managing keystores and certificates, needed for SSL key generation.
- **Recommended IDE**: [IntelliJ IDEA](https://www.jetbrains.com/idea/) for an enhanced coding experience. This project is created in IntelliJ IDEA.

## Table of Contents

- [Unit 2: Internet Addresses](#unit-2-internet-addresses)
- [Unit 3: URLs and URIs](#unit-3-urls-and-uris)
- [Unit 4: HTTP](#unit-4-http)
- [Unit 5: URLConnections](#unit-5-urlconnections)
- [Unit 6: Socket for Clients](#unit-6-socket-for-clients)
- [Unit 7: Socket for Servers](#unit-7-socket-for-servers)
- [Unit 8: Secure Sockets (SSL/TLS)](#unit-8-secure-sockets-ssltls)
  - [SSL Key Generation](#ssl-key-generation-for-client-and-server)
- [Unit 9: Non-blocking I/O](#unit-9-non-blocking-io)
- [Unit 10: UDP](#unit-10-udp)
- [Unit 11: IP Multicast](#unit-11-ip-multicast)
- [Unit 12: Remote Method Invocation (RMI)](#unit-12-remote-method-invocation-rmi)

---

### Unit 2: Internet Addresses
This unit focuses on the `InetAddress` class, which is used to represent IP addresses, both IPv4 and IPv6. Key code functionalities include:
- **Creating InetAddress Objects**: Instantiate objects using hostnames or IP addresses.
- **Testing Reachability**: Check if an IP address is reachable via the `isReachable` method.
- **Retrieving Host Information**: Use `getHostName`, `getHostAddress`, and `getByName` methods to obtain various details about a host.

### Unit 3: URLs and URIs
This unit covers the `URL` and `URI` classes for managing web addresses:
- **Creating URLs**: Construct `URL` objects and retrieve data from specified URLs.
- **Parsing URLs**: Split URLs into their constituent parts, allowing manipulation of components like protocol, host, port, and file.
- **Encoding/Decoding**: Utilize URL encoding/decoding for transmitting special characters safely.

### Unit 4: HTTP
Here, the `HttpURLConnection` class is utilized to manage HTTP requests:
- **Sending GET and POST Requests**: Demonstrate how to communicate with web servers using different HTTP methods.
- **Handling Cookies**: Use the `CookieManager` to manage cookies for session handling.

### Unit 5: URLConnections
This unit builds on `HttpURLConnection` and `URLConnection` classes:
- **Opening Connections**: Open a connection to a specified URL and handle responses.
- **Reading Data**: Retrieve content from the server, process headers, and manage cache settings.

### Unit 6: Socket for Clients
This unit implements the `Socket` class for client-side communication:
- **Connecting to Servers**: Establish a connection to a server using its IP address and port.
- **Reading/Writing Data**: Send and receive data from the server using input/output streams.
- **Socket Options**: Configure socket options like timeouts and buffer sizes.

### Unit 7: Socket for Servers
This unit focuses on `ServerSocket` for server-side applications:
- **Listening for Connections**: Set up a server to listen for incoming client connections.
- **Handling Multiple Clients**: Implement multithreading to handle multiple client requests concurrently.
- **Logging**: Create logs for incoming requests for monitoring and debugging.

### Unit 8: Secure Sockets (SSL/TLS)
This unit involves secure communication using `SSLServerSocket` and `SSLSocket`:
- **Configuring SSL**: Establish SSL connections with proper configuration for secure data transmission.
- **Session Management**: Handle sessions and manage encryption protocols.

#### SSL Key Generation for Client and Server
Before running the code in Unit 8, you must generate SSL keys for both the client and server using the `keytool` command:

```bash
# Generate a keystore for the server
keytool -genkeypair -alias server -keyalg RSA -keystore server.keystore -validity 365 -storepass changeit -keypass changeit

# Generate a keystore for the client
keytool -genkeypair -alias client -keyalg RSA -keystore client.keystore -validity 365 -storepass changeit -keypass changeit

# Export the server certificate
keytool -export -alias server -keystore server.keystore -file server.cer -storepass changeit

# Import the server certificate into the client's keystore
keytool -import -alias server -file server.cer -keystore client.keystore -storepass changeit


### Unit 9: Non-blocking I/O
This unit demonstrates non-blocking I/O using channels and selectors:
- **Using Channels**: Implement `SocketChannel` and `ServerSocketChannel` for non-blocking communication.
- **Selectors**: Manage multiple channels with the `Selector` class for efficient I/O operations.
- **Buffers**: Use `ByteBuffer` for reading and writing data to channels. Key methods include `put()`, `get()`, `flip()`, and `compact()` for managing data flow.

### Unit 10: UDP
This unit covers User Datagram Protocol (UDP):
- **UDP Sockets**: Utilize `DatagramSocket` for connectionless communication.
- **Datagram Packets**: Send and receive data packets using `DatagramPacket`.
- **Datagram Channel**: Implement `DatagramChannel` for non-blocking communication over UDP, allowing for the sending and receiving of datagrams in an efficient manner.

### Unit 11: IP Multicast
This unit explores multicasting:
- **Multicast Sockets**: Create multicast sockets to send and receive data to multiple clients.

### Unit 12: Remote Method Invocation (RMI)
This unit covers RMI for distributed applications:
- **Defining RMI Services**: Create service interfaces and implement remote methods.
- **RMI Client and Server**: Set up RMI clients and servers for remote communication.

