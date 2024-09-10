package Unit11.SimpleMultcastSocket2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastReceiverB{
    public static void main(String[] args) throws IOException {
        MulticastSocket socket = new MulticastSocket(4444);
        byte[] buf = new byte[256];
        InetAddress group = InetAddress.getByName("224.0.0.1");
        socket.joinGroup(group);
        while(true){
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            byte[] data = packet.getData();
            String msg = new String(data, 0, packet.getLength());
            System.out.println("Received: " + msg);
        }
    }
}
