package Unit5;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class ServerHeaderReader {
    public static void main(String[] args) throws Exception {
        // Specify the URL of the server endpoint
        String url = "http://example.com/api/data"; // Replace with your actual endpoint URL

        // Create a URL object
        URL serverUrl = new URL(url);

        // Open a connection to the server
        HttpURLConnection connection = (HttpURLConnection) serverUrl.openConnection();

        // Set the HTTP request method
        connection.setRequestMethod("GET");

        // Get the response code from the server
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        // If the response code indicates a successful request
        if (responseCode == HttpURLConnection.HTTP_OK) {
            // Get the headers from the response
            Map<String, List<String>> headers = connection.getHeaderFields();
            System.out.println("Headers: ");
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                String key = entry.getKey();
                String value = String.valueOf(entry.getValue());
                System.out.println(key + ": " + value);
            }
        } else {
            System.out.println("Error: " + responseCode);
        }

        // Close the connection
        connection.disconnect();
    }
}
