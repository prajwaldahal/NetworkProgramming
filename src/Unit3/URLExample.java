package Unit3;

import java.net.URL;
import java.net.MalformedURLException;
public class URLExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.kcmit.edu.np:8080/index.html");
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host: " + url.getHost());
            System.out.println("Port: " + url.getPort());
            System.out.println("File: " + url.getFile());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}

