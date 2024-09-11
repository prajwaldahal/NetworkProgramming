package Unit9.Channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class SimpleServer {
    public static void main(String[] args) {
        try {
            // Open a ServerSocketChannel
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            // Bind the server to port 5000
            serverSocketChannel.bind(new InetSocketAddress(5000));

            System.out.println("Server is listening on port 5000...");

            while (true) {
                // Accept the client connection
                SocketChannel socketChannel = serverSocketChannel.accept();
                System.out.println("Client connected!");

                // Allocate a buffer for reading data
                ByteBuffer buffer = ByteBuffer.allocate(1024);

                // Read data from the client
                socketChannel.read(buffer);
                buffer.flip();
                String receivedData = new String(buffer.array(), 0, buffer.limit());
                System.out.println("Received from client: " + receivedData);

                // Send a response back to the client
                String response = "Hello from Server!";
                buffer.clear();
                buffer.put(response.getBytes());
                buffer.flip();
                socketChannel.write(buffer);

                // Close the connection with the client
                socketChannel.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
