package Unit11.SimpleMultiSocket;

import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.DatagramPacket;
import java.io.IOException;

public class MulticastReceiver {
    public static void main(String[] args) {
        try {
            MulticastSocket socket = new MulticastSocket(5000);
            InetAddress group = InetAddress.getByName("224.0.0.1");
            socket.joinGroup(group);
            byte[] buffer = new byte[256];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            String received = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Received: " + received);
            socket.leaveGroup(group);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
