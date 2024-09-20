package Unit9.Channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SimpleClient {
    public static void main(String[] args) {
        try {

            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("localhost", 5000));

            ByteBuffer buffer = ByteBuffer.allocate(1024);

            String message = "Hello from Client!";
            buffer.put(message.getBytes());
            buffer.flip();
            socketChannel.write(buffer);
            System.out.println("Sent to server: " + message);
            buffer.clear();


            socketChannel.read(buffer);
            buffer.flip();
            String response = new String(buffer.array(), 0, buffer.limit());
            System.out.println("Received from server: " + response);

            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
