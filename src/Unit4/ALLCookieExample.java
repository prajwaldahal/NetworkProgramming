package Unit4;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.List;

public class ALLCookieExample {

    public static void main(String[] args) throws Exception {
        // Create a CookieManager
        CookieManager cookieManager = new CookieManager();
        CookieHandler.setDefault(cookieManager);
        CookieStore cookieStore = cookieManager.getCookieStore();

        // Send an HTTP GET request
        URL url = new URL("https://kcmit.edu.np");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Read the response
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            System.out.println("Response Code: " + responseCode);

            // Get the cookies from the CookieStore
            List<HttpCookie> cookies = cookieStore.getCookies();
            System.out.println("Cookies:");
            for (HttpCookie cookie : cookies) {
                System.out.println(cookie);
            }

            // Add a new cookie to the CookieStore
            HttpCookie newCookie = new HttpCookie("myCookie", "1234");
            newCookie.setDomain(".kcmit.edu.np");
            newCookie.setPath("/");
            cookieStore.add(URI.create("https://kcmit.edu.np"), newCookie);
            System.out.println("New cookie added to the store.");

            // Send another HTTP GET request
            URL url2 = new URL("https://kcmit.edu.np");
            HttpURLConnection connection2 = (HttpURLConnection) url2.openConnection();
            connection2.setRequestMethod("GET");

            // Read the response
            int responseCode2 = connection2.getResponseCode();
            if (responseCode2 == HttpURLConnection.HTTP_OK) {
                System.out.println("Response Code: " + responseCode2);

                // Get the cookies from the CookieStore
                List<HttpCookie> cookies2 = cookieStore.getCookies();
                System.out.println("Cookies:");
                for (HttpCookie cookie : cookies2) {
                    System.out.println(cookie);
                }
            } else {
                System.out.println("GET request failed. Response Code: " + responseCode2);
            }
            connection2.disconnect();
        } else {
            System.out.println("GET request failed. Response Code: " + responseCode);
        }
        connection.disconnect();
    }
}
