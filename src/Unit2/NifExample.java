package Unit2;

import java.io.*;
import java.net.*;
import java.util.Enumeration;

public class NifExample {
    public static void main(String[] args) throws SocketException {
Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface networkInterface = interfaces.nextElement();
            System.out.println("Name: " + networkInterface.getName());
            System.out.println("Display Name: " + networkInterface.getDisplayName());
            System.out.println("MTU: " + networkInterface.getMTU());

            byte[] hardwareAddress = networkInterface.getHardwareAddress();
            if (hardwareAddress != null) {
                StringBuilder sb = new StringBuilder();
                for (byte b : hardwareAddress) {
                    sb.append(String.format("%02X ", b));
                }
                System.out.println("MAC Address: " + sb.toString().trim());
            }

            Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
            while (inetAddresses.hasMoreElements()) {
                InetAddress inetAddress = inetAddresses.nextElement();
                System.out.println("IP Address: " + inetAddress.getHostAddress());
            }
            System.out.println();
        }
    }
}
