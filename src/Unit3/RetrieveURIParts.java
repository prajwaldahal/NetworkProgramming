package Unit3;

import java.net.URI;
import java.net.URISyntaxException;

public class RetrieveURIParts {

    public static void main(String[] args) throws Exception {
        String uri = "https://www.kcmit.edu.np/path/to/resource?param1=value1&param2=value2#fragment";

        // Create a URI object from the URI string
        URI parsedURI = new URI(uri);

        // Retrieve the scheme
        String scheme = parsedURI.getScheme();

        // Retrieve the authority
        String authority = parsedURI.getAuthority();

        // Retrieve the path
        String path = parsedURI.getPath();

        String query =parsedURI.getQuery();

        String fragment=parsedURI.getFragment();

        // Print the scheme, authority, and path
        System.out.println("Scheme: " + scheme);
        System.out.println("Authority: " + authority);
        System.out.println("Path: " + path);
        System.out.println("fragment:"+fragment);
        System.out.println("query:"+query);
    }
}