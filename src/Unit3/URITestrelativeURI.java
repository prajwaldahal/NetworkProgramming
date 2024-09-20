package Unit3;

import java.net.URI;
import java.net.URISyntaxException;
public class URITestrelativeURI {
    public static void main(String[] args) {
        try {
            String path = "path/to/resource";
            String query = "param1=value1&param2=value2";
            URI uri = new URI(path);
            uri = new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), query, uri.getFragment());
            System.out.println(uri);
        }
        catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
