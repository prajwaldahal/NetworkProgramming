package Unit5;

import java.io.*;
import java.net.*;

public class myURLConnectionExample {
    public static void main(String[] args) {
        try {
            // Create a URL object
            URL url = new URL("http://www.kcmit.edu.np");

            // Open a connection to the URL
            URLConnection connection = url.openConnection();

            // Configure the connection properties
            connection.setRequestProperty("User-Agent", "Mozilla/5.0"); // Set user agent

            // Connect to the URL
            connection.connect();

            // Read the response from the server
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }

            // Close the input stream and disconnect the connection
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
