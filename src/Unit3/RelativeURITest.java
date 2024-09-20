package Unit3;

import java.net.URI;
import java.net.URISyntaxException;

public class RelativeURITest {
    public static void main(String[] args) {
        try {
            // Base URI
            URI baseURI = new URI("https://www.kcmit.edu.np/basepath/");

            // Relative URI
            URI relativeURI = new URI("resource/path?param=value");

            // Resolving relative URI against base URI
            URI resolvedURI = baseURI.resolve(relativeURI);

            System.out.println("Base URI: " + baseURI);
            System.out.println("Relative URI: " + relativeURI);
            System.out.println("Resolved URI: " + resolvedURI);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
