package Unit2;

import java.net.*;

public class Example {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("www.ims.edu.np");
            System.out.println("IP address: " + address.getHostAddress());
        } catch (UnknownHostException e) {
            System.err.println("Unable to resolve host");
        }
    }
}