package Unit3;

import java.net.URI;
import java.net.URISyntaxException;
public class URITestCreate1 {
    public static void main(String[] args) {
        try {
            URI uri = new URI("https", "kcmit.edu.np", "/path", "query=param","DCfragment");
            System.out.println("URI: " + uri.toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
