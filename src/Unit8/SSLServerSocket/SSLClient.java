import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;

public class SSLClient {

    public static void main(String[] args) throws Exception {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        try (FileInputStream keyStoreInput = new FileInputStream("client.keystore")) {
            keyStore.load(keyStoreInput, "changeit".toCharArray());
        }

        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(keyStore);

        // Create and initialize the SSLContext
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, tmf.getTrustManagers(), null);

        // Create an SSLSocketFactory and connect to the server
        SSLSocketFactory sf = sslContext.getSocketFactory();
        try (SSLSocket socket = (SSLSocket) sf.createSocket("localhost", 1234)) {
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            writer.println("Hello from SSL Client");
            String response = reader.readLine();
            System.out.println("Received: " + response);
        }
    }
}
