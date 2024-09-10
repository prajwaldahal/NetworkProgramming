package Unit8.HTTPSClient;

import java.io.*;
import javax.net.ssl.*;

public class HTTPSClient {
    public static void main(String[] args) {
        int port = 443;
        String host = "www.usps.com";

        try {

            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket socket = (SSLSocket) factory.createSocket(host, port);
            socket.setEnabledCipherSuites(socket.getSupportedCipherSuites());


            Writer out = new OutputStreamWriter(socket.getOutputStream());
            out.write("GET https://" + host + "/ HTTP/1.1\r\n");
            out.write("Host: " + host + "\r\n");
            out.write("\r\n");
            out.flush();

            // Read response
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;

            // Print headers
            while (!(line = in.readLine()).isEmpty()) {
                System.out.println(line);
            }
            System.out.println();

            // Print response body
            String c;
            while ((c = in.readLine()) != null) {
                System.out.println(c);
            }

            // Close connections
            out.close();
            in.close();
            socket.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
