package Unit8.SSLServerSocket;

import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;

public class SSLServer {

    public static void main(String[] args) throws Exception {
        // Load the server's keystore
        KeyStore keyStore = KeyStore.getInstance("JKS");
        try (FileInputStream keyStoreInput = new FileInputStream("server.keystore")) {
            keyStore.load(keyStoreInput, "changeit".toCharArray());
        }

        // Initialize the KeyManagerFactory with the server's keystore
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        kmf.init(keyStore, "changeit".toCharArray());

        // Create and initialize the SSLContext
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(kmf.getKeyManagers(), null, null);

        // Create an SSLServerSocketFactory and bind it to port 1234
        SSLServerSocketFactory ssf = sslContext.getServerSocketFactory();
        try (SSLServerSocket serverSocket = (SSLServerSocket) ssf.createServerSocket(1234)) {
            System.out.println("SSL Server is running...");
            try (SSLSocket socket = (SSLSocket) serverSocket.accept()) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                String message = reader.readLine();
                System.out.println("Received: " + message);

                writer.println("Hello from SSL Server");
            }
        }
    }
}
