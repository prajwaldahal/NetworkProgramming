package Unit5;

import java.net.HttpURLConnection;
import java.net.URL;

public class HttpHeaderExample {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://example.com");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        String contentType = connection.getHeaderField("Content-Type");
        String server = connection.getHeaderField("Server");

        System.out.println("Content-Type: " + contentType);
        System.out.println("Server: " + server);

        connection.disconnect();
    }
}
