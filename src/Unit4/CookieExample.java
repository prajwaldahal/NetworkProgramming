package Unit4;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.net.HttpCookie;

public class CookieExample {

    public static void main(String[] args) throws Exception {
        // Create a CookieManager
        CookieManager cookieManager = new CookieManager();
        CookieHandler.setDefault(cookieManager);

        // Send an HTTP GET request
        URL url = new URL("https://www.kcmit.edu.np");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        // Print the cookies before making the request
        List<HttpCookie> cookiesBefore = cookieManager.getCookieStore().get(URI.create("https://www.kcmit.edu.np"));
        System.out.println("Cookies before: " + cookiesBefore);
        // Make the request
        connection.connect();
        // Print the cookies after making the request
        List<HttpCookie> cookiesAfter = cookieManager.getCookieStore().get(URI.create("https://www.kcmit.edu.np"));
        System.out.println("Cookies after: " + cookiesAfter);
        // Disconnect the connection
        connection.disconnect();
    }
}
