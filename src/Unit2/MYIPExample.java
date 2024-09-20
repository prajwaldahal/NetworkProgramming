package Unit2;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class MYIPExample {
    
    public static void main(String[] args) throws UnknownHostException {
        
        // Get IPv4 address by hostname
        InetAddress inet4 = InetAddress.getByName("www.google.com");
        if (inet4 instanceof Inet4Address) {
            System.out.println("IPv4 address: " + inet4.getHostAddress());
        }
        
        // Get IPv6 address by hostname
        InetAddress inet6 = InetAddress.getByName("2a03:2880:f11c:8183:face:b00c::25de");
        if (inet6 instanceof Inet6Address) {
            System.out.println("IPv6 address: " + inet6.getHostAddress());
        }
        
        // Get local host IP addresses
        InetAddress[] addresses = InetAddress.getAllByName("localhost");
        for (InetAddress address : addresses) {
            System.out.println("Local address: " + address.getHostAddress());
        }
        
    }
}
