package Unit2;

import java.net.*;
import java.util.Enumeration;

public class IPandMACAddress {
    public static void main(String[] args) {
        try {

            InetAddress ip = InetAddress.getLocalHost();
            System.out.println("IP Address: " + ip.getHostAddress());


            Enumeration<NetworkInterface> networks = NetworkInterface.getNetworkInterfaces();
            while (networks.hasMoreElements()) {
                NetworkInterface network = networks.nextElement();
                

                byte[] mac = network.getHardwareAddress();
                
                if (mac != null) {
                    System.out.print("MAC Address: ");
                    for (int i = 0; i < mac.length; i++) {
                        System.out.format("%02X%s", mac[i], (i < mac.length - 1) ? "::" : "");
                    }
                    System.out.println();
                }
            }
        } catch (UnknownHostException e) {
            System.out.println("Unable to retrieve IP address.");
            e.printStackTrace();
        } catch (SocketException e) {
            System.out.println("Unable to retrieve MAC address.");
            e.printStackTrace();
        }
    }
}
