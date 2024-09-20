package Unit5;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HeaderFieldExampleGH {
    public static void main(String[] args) {
        try {
            // Create a URL object
            URL url = new URL("https://www.example.com");

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Get the header fields by name
            String customHeader1 = connection.getHeaderField("X-Custom-Header-1");
            String customHeader2 = connection.getHeaderField("X-Custom-Header-2");

            // Print the header fields
            System.out.println("X-Custom-Header-1: " + customHeader1);
            System.out.println("X-Custom-Header-2: " + customHeader2);

            // Get the header fields by index
            for (int i = 0; ; i++) {
                String headerField = connection.getHeaderField(i);
                if (headerField == null) {
                    break;
                }
                System.out.println("Header field " + i + ": " + headerField);
            }

            // Close the connection
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
