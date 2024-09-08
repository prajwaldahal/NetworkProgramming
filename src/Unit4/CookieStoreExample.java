package Unit4;

import java.net.*;
import java.util.List;

public class CookieStoreExample {

    public static void main(String[] args) throws URISyntaxException {
        CookieManager cookieManager = new CookieManager();
		cookieManager.setCookiePolicy(new NoGovermentCookies());
        CookieStore cookieStore = cookieManager.getCookieStore();
        URI uri= new URI("http://example.gov");

        HttpCookie cookie = new HttpCookie("name", "value");
        cookie.setDomain(uri.toString());
        cookie.setPath("/");
        cookie.setMaxAge(1000);

        cookieStore.add(uri, cookie);
        List<HttpCookie> retrievedCookie = cookieStore.get(uri);
        System.out.println(retrievedCookie);

        for(HttpCookie cookie1:retrievedCookie){
            System.out.println(cookie1.getName());
            System.out.println(cookie1.getValue());
            System.out.println(cookie1.getDomain());
        }

        cookieStore.remove(uri, cookie);
    }
}
