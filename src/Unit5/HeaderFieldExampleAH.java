package Unit5;

import java.io.*;
import java.net.*;

public class HeaderFieldExampleAH {
    public static void main(String[] args) {
        try {
            // Create a URL object
            URL url = new URL("http://counseling.kcmit.edu.np/");

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Get the content length as an integer
            int contentLength = connection.getHeaderFieldInt("Content-Length", -1);
            System.out.println("Content-Length: " + contentLength);

            // Get the content type
            String contentType = connection.getHeaderField("Content-Type");
            System.out.println("Content-Type: " + contentType);

            // Get the name of the first header field
            String headerFieldKey = connection.getHeaderFieldKey(0);
            System.out.println("First header field: " + headerFieldKey);

            // Get the value of the first header field
            String headerFieldValue = connection.getHeaderField(0);
            System.out.println("Value of first header field: " + headerFieldValue);

            // Get the last modified date
            long lastModified = connection.getHeaderFieldDate("Last-Modified", 0);
            System.out.println("Last-Modified: " + lastModified);

            // Close the connection
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
