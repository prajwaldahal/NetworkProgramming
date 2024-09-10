package Unit11.SimpleMultiSocket;

import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.DatagramPacket;
import java.io.IOException;

public class MulticastSender {
    public static void main(String[] args) {
        try {
            MulticastSocket socket = new MulticastSocket();
            InetAddress group = InetAddress.getByName("224.0.0.1");
            String message = "Hello, Multicast!";
            DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(), group, 5000);
            socket.send(packet);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
