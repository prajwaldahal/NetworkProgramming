package Unit9.Channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SimpleClient {
    public static void main(String[] args) {
        try {
            // Open a SocketChannel
            SocketChannel socketChannel = SocketChannel.open();
            // Connect to the server at localhost on port 5000
            socketChannel.connect(new InetSocketAddress("localhost", 5000));

            // Allocate a buffer for sending data
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            // Send a message to the server
            String message = "Hello from Client!";
            buffer.put(message.getBytes());
            buffer.flip();
            socketChannel.write(buffer);
            System.out.println("Sent to server: " + message);

            // Clear the buffer for reading data
            buffer.clear();

            // Read the response from the server
            socketChannel.read(buffer);
            buffer.flip();
            String response = new String(buffer.array(), 0, buffer.limit());
            System.out.println("Received from server: " + response);

            // Close the connection
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
