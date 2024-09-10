package Unit10.DateConverterUDPServer;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Server {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(1234);
            byte[] receiveBuffer = new byte[1024];
            System.out.println("Server is listening on port 1234...");

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                socket.receive(receivePacket);
                String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());

                try {
                    System.out.println("Messsage Recieved and is being Proccessed");
                    LocalDate date = LocalDate.parse(receivedMessage);
                    LocalDate updateDate = date.minusYears(56).minusMonths(8).minusDays(17);

                    byte[] send = updateDate.toString().getBytes();
                    DatagramPacket sendPacket = new DatagramPacket(send, send.length, receivePacket.getAddress(), receivePacket.getPort());
                    socket.send(sendPacket);
                    System.out.println("data successfully Proceed and sent");
                    System.out.println();
                } catch (DateTimeParseException e) {
                    System.out.println("ERROR:Invalid Date Format");
                    System.out.println();
                    byte[] sendError = "Invalid Date".getBytes();
                    DatagramPacket sendErrorPacket = new DatagramPacket(sendError, sendError.length, receivePacket.getAddress(), receivePacket.getPort());
                    socket.send(sendErrorPacket);
                }
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
