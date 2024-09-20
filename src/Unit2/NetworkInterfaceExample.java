package Unit2;

import java.net.*;
import java.util.Enumeration;

public class NetworkInterfaceExample {
    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface ni = interfaces.nextElement();
            System.out.println("Interface: " + ni.getName());
            System.out.println("Display Name: " + ni.getDisplayName());
            System.out.println("Addresses:");
            Enumeration<InetAddress> addresses = ni.getInetAddresses();
            while (addresses.hasMoreElements()) {
                InetAddress addr = addresses.nextElement();
                System.out.println("  " + addr);
            }
        }
    }
}
