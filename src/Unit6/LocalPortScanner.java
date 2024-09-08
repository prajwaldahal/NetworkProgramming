package Unit6;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class LocalPortScanner {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println("Scanning ports on: " + inetAddress);

        int totalPorts = 65536;
        for (int i = 1233; i < totalPorts; i++) {
            try {
                Socket socket = new Socket(inetAddress, i);
                System.out.println("Port " + i + " is open");
                socket.close();
            } catch (IOException e) {
                 System.out.println("Port " + i + " is closed");
            }

            // Show progress as a floating-point value
            double progress = (i * 100.0) / totalPorts;
            System.out.print("\033[A");  // ANSI escape code to move up one line
            System.out.printf("Scanning progress: %.2f%%\n", progress);
        }

        System.out.println("Port scanning completed.");
    }
}
