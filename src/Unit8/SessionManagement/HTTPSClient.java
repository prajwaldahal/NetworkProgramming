package Unit8.SessionManagement;

import java.io.*;
import java.util.Arrays;
import javax.net.ssl.*;

public class HTTPSClient {
    public static void main(String[] args) {
        int port = 443;
        String host = "www.usps.com";

        try {

            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket socket = (SSLSocket) factory.createSocket(host, port);
            socket.setEnabledCipherSuites(socket.getSupportedCipherSuites());
            socket.addHandshakeCompletedListener(new HandshakeCompletedListener() {
                @Override
                public void handshakeCompleted(HandshakeCompletedEvent handshakeCompletedEvent) {
                    SSLSession session = handshakeCompletedEvent.getSession();
                    System.out.println("ID:"+session.getId());
                    System.out.println("Creation Time:"+session.getCreationTime());
                    System.out.println("Last Accesed Time:"+session.getLastAccessedTime());
                    session.putValue("key","xyz");
                    System.out.println(session.getValue("key"));;
                    System.out.println(Arrays.toString( session.getValueNames()));
                    System.out.println(session.getCipherSuite());
                    System.out.println(session.getPeerHost());
                    System.out.println("Last Accesed Time:"+session.getLastAccessedTime());
                    System.out.println("Last Accesed Time:"+session.getLastAccessedTime());
                    System.out.println("Last Accesed Time:"+session.getLastAccessedTime());
                    System.out.println("Last Accesed Time:"+session.getLastAccessedTime());
                }
            });

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

             //Print response body
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

