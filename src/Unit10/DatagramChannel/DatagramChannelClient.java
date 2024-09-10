package Unit10.DatagramChannel;

import java.net.*;
import java.nio.*;
import java.nio.channels.*;

public class DatagramChannelClient {
    public static void main(String[] args) {
        try {

            DatagramChannel clientChannel = DatagramChannel.open();
            InetSocketAddress serverAddress = new InetSocketAddress("localhost", 9999);
            String message = "Hello from the DatagramChannel client!";
            ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());

            clientChannel.send(buffer, serverAddress);
            System.out.println("Message sent to server.");
            ByteBuffer responseBuffer = ByteBuffer.allocate(1024);
            clientChannel.receive(responseBuffer);
            responseBuffer.flip();

            byte[] responseData = new byte[responseBuffer.remaining()];
            responseBuffer.get(responseData);
            String response = new String(responseData);
            System.out.println("Received from server: " + response);
            clientChannel.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
