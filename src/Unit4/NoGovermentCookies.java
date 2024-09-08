package Unit4;

import java.net.*;
public class NoGovermentCookies implements CookiePolicy {

public boolean shouldAccept(URI uri, HttpCookie cookie) {
	if(cookie.getDomain().endsWith(".gov")) {
	 return false;
	}
	return true;
}
}