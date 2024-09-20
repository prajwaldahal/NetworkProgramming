package Unit5;

import java.io.*;
import java.net.*;
import java.util.*;

public class HeaderFieldExample {
    public static void main(String[] args) {
        try {
            // Create a URL object
            URL url = new URL("https://www.google.com");

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Get the header fields
            String contentType = connection.getContentType();
            int contentLength = connection.getContentLength();
            String contentEncoding = connection.getContentEncoding();
            Date date = new Date(connection.getDate());
            Date lastModified = new Date(connection.getLastModified());
            Date expires = new Date(connection.getExpiration());

            // Print the header fields
            System.out.println("Content-Type: " + contentType);
            System.out.println("Content-Length: " + contentLength);
            System.out.println("Content-Encoding: " + contentEncoding);
            System.out.println("Date: " + date);
            System.out.println("Last-Modified: " + lastModified);
            System.out.println("Expires: " + expires);

            // Close the connection
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
