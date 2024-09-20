package Unit5;

import java.io.*;
import java.net.*;
import java.util.*;

public class URLHeaderReader {
    public static void main(String[] args) throws IOException {
        // Specify the URL of the server endpoint
        String url = "http://kcmit.edu.np/result/"; 
        // Create a URL object
        URL serverUrl = new URL(url);
        // Open a connection to the server
        HttpURLConnection connection = (HttpURLConnection) serverUrl.openConnection();
        // Set the HTTP request method
        connection.setRequestMethod("GET");
        // Get the headers from the server response
        Map<String, List<String>> headers = connection.getHeaderFields();
        // Print each header and its value
        for (String key : headers.keySet()) {
            System.out.println(key + ": " + headers.get(key));
        }

        // Close the connection
        connection.disconnect();
    }
}
