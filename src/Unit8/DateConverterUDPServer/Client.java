package Unit8.SimpleUDPProgram;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            // Create a DatagramSocket
            socket = new DatagramSocket();

            // Get the server's IP address (localhost in this case)
            InetAddress serverAddress = InetAddress.getByName("localhost");

            Scanner scanner = new Scanner(System.in);

            // Continuously send messages to the server
            while (true) {
                System.out.print("Enter Date in YYYY-MM-DD format: ");
                String message = scanner.nextLine();

                // Convert the message to a byte array
                byte[] sendBuffer = message.getBytes();

                // Create a DatagramPacket to send data to the server on port 1234
                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, 1234);

                // Send the packet
                socket.send(sendPacket);

                System.out.println("Message sent to the server.");
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
