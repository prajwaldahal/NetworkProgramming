package Unit2;

import java.net.*;

public class IPAddressExample {
  public static void main(String[] args) {
    try {
      String hostname = "www.google.com";

      // Get the IP addresses for the given host name
      InetAddress[] addresses = InetAddress.getAllByName(hostname);

      // Print the IP addresses
      for (InetAddress addr : addresses) {
        if (addr instanceof Inet4Address) {
          System.out.println("IPv4 address: " + addr.getHostAddress());
        } else if (addr instanceof Inet6Address) {
          System.out.println("IPv6 address: " + addr.getHostAddress());
        }
      }
    } catch (UnknownHostException ex) {
      System.err.println("Could not resolve hostname");
    }
  }
}
