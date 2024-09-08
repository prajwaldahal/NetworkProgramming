package Unit2;

import java.net.*;
import java.io.*;

public class HostLookup {
    public static void main(String[] args) {
        if (args.length > 0) { // use command line arguments
            for (int i = 0; i < args.length; i++) {
                System.out.println(lookup(args[i]));
            }
        } else {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter names and IP addresses. Enter \"exit\" to quit.");
            try {
                while (true) {
                    String host = in.readLine();
                    if (host.equalsIgnoreCase("exit") || host.equalsIgnoreCase("quit")) {
                        break;
                    }
                    System.out.println(lookup(host));
                }
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }

    private static String lookup(String host) {
        InetAddress node;
        try {
            // Get the InetAddress object based on the host (IP or hostname)
            node = InetAddress.getByName(host);
        } catch (UnknownHostException ex) {
            return "Cannot find host: " + host;
        }

        // Check if the input is a hostname or an IP address
        if (isHostname(host)) {
            return "IP Address: " + node.getHostAddress(); // It's a hostname, return its IP
        } else {
            return "Hostname: " + node.getHostName(); // It's an IP address, return the hostname
        }
    }

    private static boolean isHostname(String host) {
        // Check if it's an IPv6 address by looking for ':'
        if (host.indexOf(':') != -1) return false;

        char[] ca = host.toCharArray();

        // Loop through characters to determine if it's a hostname or an IP address
        for (int i = 0; i < ca.length; i++) {
            if (!Character.isDigit(ca[i])) {
                if (ca[i] != '.') return true; // It's a hostname if there's a non-digit and non-period character
            }
        }

        // If it's only digits and periods, it's an IPv4 address
        return false;
    }
}
