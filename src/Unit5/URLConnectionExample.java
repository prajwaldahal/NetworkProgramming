package Unit5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionExample {
    public static void main(String[] args) {
        try {
            // Create a URL object
            URL url = new URL("https://kcmit.edu.np");
            
            // Open a connection to the URL
            URLConnection connection = url.openConnection();
            
            // Get the input stream from the connection
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            
            // Read the response from the server
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            
            // Close the input stream
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
