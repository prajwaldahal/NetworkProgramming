package Unit10.DateConverterUDPServer;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");

            Scanner scanner = new Scanner(System.in);
            byte [] buffer= new byte[1024];
           if(!socket.isClosed())
            while (true) {
                System.out.println();
                System.out.print("Enter Date in YYYY-MM-DD format(BS): ");
                String message = scanner.nextLine();
                byte[] sendBuffer = message.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, 1234);
                socket.send(sendPacket);

                DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(receivePacket);
                String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                if(!receivedMessage.toLowerCase().equals("invalid date"))
                    System.out.println("Converted Date(AD): " + receivedMessage);
                else
                    System.out.println(receivedMessage);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}
