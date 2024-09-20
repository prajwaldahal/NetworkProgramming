package Unit4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;

public class NewCookieManagerExample {

    public static void main(String[] args) throws Exception {
        // Create a CookieManager
        CookieManager cookieManager = new CookieManager();
        CookieHandler.setDefault(cookieManager);

        // Send an HTTP GET request
        URL url = new URL("https://kcmit.edu.np");
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
        List<HttpCookie> cookies = cookieManager.getCookieStore().getCookies();

        // Print the cookies
        System.out.println("Cookies: ");
        for (HttpCookie cookie : cookies) {
            System.out.println(cookie);
        }

        // Do something with the response
        System.out.println("Response: " + response.toString());

        // Close the connection
        connection.disconnect();
    }
}
