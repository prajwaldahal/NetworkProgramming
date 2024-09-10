package Unit10.HalfDuplex;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Scanner;

public class UDPServer {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(1234);
            System.out.println("Server started");
            byte[] buf = new byte[1024];
            Scanner scanner = new Scanner(System.in);
            while (true) {
                DatagramPacket dp = new DatagramPacket(buf, buf.length);
                socket.receive(dp);
                String message = new String(dp.getData(),0,dp.getLength());
                System.out.println("Received From Client: " + message);
                System.out.println();
                System.out.print("Enter the message to sent to client: ");
                String msg = scanner.nextLine();
                DatagramPacket sendPacket= new DatagramPacket(msg.getBytes(), msg.length(), dp.getAddress(), dp.getPort());
                socket.send(sendPacket);
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
