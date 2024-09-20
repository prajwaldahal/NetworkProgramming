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
            node = InetAddress.getByName(host);
        } catch (UnknownHostException ex) {
            return "Cannot find host: " + host;
        }

        if (isHostname(host)) {
            return "IP Address: " + node.getHostAddress();
        } else {
            return "Hostname: " + node.getHostName();
        }
    }

    private static boolean isHostname(String host) {
        if (host.indexOf(':') != -1) return false;

        char[] ca = host.toCharArray();

        for (int i = 0; i < ca.length; i++) {
            if (!Character.isDigit(ca[i])) {
                if (ca[i] != '.') return true;
            }
        }

        // If it's only digits and periods, it's an IPv4 address
        return false;
    }
}
