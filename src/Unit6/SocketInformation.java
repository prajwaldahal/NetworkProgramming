package Unit6;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class SocketInformation {

    public static void main(String[] args) throws IOException {
        // Create a socket
        Socket socket = new Socket("http://www.kcmit.edu.np", 3308);

        // Get the socket information
        InetAddress hostAddress = socket.getInetAddress();
        int port = socket.getPort();
        InetAddress localAddress = socket.getLocalAddress();
        int localPort = socket.getLocalPort();

        // Print the socket information
        System.out.println("Host address: " + hostAddress);
        System.out.println("Port: " + port);
        System.out.println("Local address: " + localAddress);
        System.out.println("Local port: " + localPort);

        // Close the socket
        socket.close();
    }
}