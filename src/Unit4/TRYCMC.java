package Unit4;

import java.net.*;
import java.util.List;
public class TRYCMC {
	public static void main(String args[]) throws Exception
	{
		// URI as input
		String uri = "https://www.kcmit.edu.np/";
		// Creating an object of Cookie Manager Class
		CookieManager cookieManager = new CookieManager();
		// Setting and unsetting system wide Cookie Handler
		// using the setDefault() method
		CookieHandler.setDefault(cookieManager);
		// Pre-defined policy that accepts cookies from original server.
		CookiePolicy cookiePolicy = CookiePolicy.ACCEPT_ORIGINAL_SERVER;
		// Setting the cookie policy of the cookieManager
		// class using the setCookiePolicy() method
		cookieManager.setCookiePolicy(cookiePolicy);
		// Now, creating an object of URL class
		URL url = new URL(uri);
		// Establishing the connection over the object
		// of URLConnection class
		URLConnection connection = url.openConnection();
		// Receiving the response
		connection.getContent();
		// Lastly, creating object of CookieStore to retrieve current cookie store instance
		CookieStore cookieStore = cookieManager.getCookieStore();
		// For this, creating an List of object type HttpCookie
		List<HttpCookie> cookieList = cookieStore.getCookies();
		// Iterating over the List of objects using the for each loop
		for (HttpCookie cookie : cookieList) {
			// Print the Domain name and Cookie name using
			// using getName() and getDomain() method
			System.out.println("Domain name is: " + cookie.getDomain());
			System.out.println("Cookie name is: " + cookie.getName());
		}
	}
}