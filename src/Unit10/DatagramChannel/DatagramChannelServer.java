package Unit10.DatagramChannel;

import java.net.*;
import java.nio.*;
import java.nio.channels.*;

public class DatagramChannelServer {
    public static void main(String[] args) {
        try {
            DatagramChannel serverChannel = DatagramChannel.open();
            serverChannel.bind(new InetSocketAddress(9999));
            System.out.println("Server is listening on port 9999...");
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while (true) {
                buffer.clear();
                SocketAddress clientAddress = serverChannel.receive(buffer);
                buffer.flip();
                byte[] data = new byte[buffer.remaining()];
                buffer.get(data);
                String message = new String(data);
                System.out.println("Received from client: " + message);

                // Send a response back to the client
                String response = "Message received: " + message;
                ByteBuffer responseBuffer = ByteBuffer.wrap(response.getBytes());
                serverChannel.send(responseBuffer, clientAddress);

                System.out.println("Response sent to client.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
