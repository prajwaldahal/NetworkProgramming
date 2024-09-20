package Unit3;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
public class URLEncoderExample {
    public static void main(String[] args) {
        try {
            String url = "https://kcmit.edu.np/notices/";
            String encodedString = URLEncoder.encode(url, "UTF-8");
            System.out.println("Encoded String: " + encodedString);
            String decodedString = URLDecoder.decode(encodedString, "UTF-8");
            System.out.println("Decoded String: " + decodedString);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
