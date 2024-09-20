package Unit4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.URL;

public class CookieManagerExample {

    public static void main(String[] args) throws Exception {
        // Create a CookieManager
        CookieManager cookieManager = new CookieManager();
        CookieHandler.setDefault(cookieManager);

        // Send an HTTP GET request
        URL url = new URL("https://www.kcmit.edu.np");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Read the response
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuffer response = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        // Get the cookies from the CookieManager
        System.out.println("Cookies: " + cookieManager.getCookieStore().getCookies());

        // Do something with the response
        System.out.println("Response: " + response.toString());

        // Close the connection
        connection.disconnect();
    }
}
