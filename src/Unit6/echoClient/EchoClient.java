package Unit6.echoClient;
import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) {
        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        BufferedReader userInput = null;

        try {
            // Connect to the server on localhost and port 12345
            socket = new Socket("rama.poly.edu", 7);
            System.out.println("Connected to the server.");

            // Create PrintWriter to send data to the server
            out = new PrintWriter(socket.getOutputStream(), true);

            // Create BufferedReader to read data from the server
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Create BufferedReader to read user input from the console
            userInput = new BufferedReader(new InputStreamReader(System.in));

            String messageToSend;
            String serverResponse;

            // Continuously read input from user, send to server, and print the response
            while (true) {
                System.out.print("Enter message to send to server (type 'exit' to quit): ");
                messageToSend = userInput.readLine();

                if (messageToSend.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting...");
                    break;
                }

                // Send message to the server
                out.println(messageToSend);

                // Receive and print the server's response
                serverResponse = in.readLine();
                System.out.println("Received from server: " + serverResponse);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (userInput != null) userInput.close();
                if (in != null) in.close();
                if (out != null) out.close();
                if (socket != null && !socket.isClosed()) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
