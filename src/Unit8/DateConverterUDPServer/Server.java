package Unit8.DateConverterUDPServer;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.time.LocalDate;
import java.util.Date;

public class Server {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            // Create a DatagramSocket that listens on port 1234
            socket = new DatagramSocket(1234);
            byte[] receiveBuffer = new byte[1024];

            System.out.println("Server is listening on port 1234...");

            // Infinite loop to keep the server running
            while (true) {
                // Create a DatagramPacket to receive data from the client
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);

                // Receive data from the client
                socket.receive(receivePacket);

                // Extract data and convert it to a string
                String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());

                LocalDate date =LocalDate.parse(receivedMessage);
                LocalDate updateDate = date.minusYears(56).minusMonths(8).minusDays(17);
                System.out.println(updateDate);
                // Optionally, you could send a response back to the client
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

