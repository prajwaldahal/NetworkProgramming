package Unit3;

import java.io.IOException;
import java.net.*;
import java.util.Collections;
import java.util.List;

// Custom ProxySelector implementation
class MyProxySelector extends ProxySelector {
    @Override
    public List<Proxy> select(URI uri) {
        // Custom logic to select proxies based on URI
        // In this example, we always return a proxy with "proxy.example.com" as host and 8080 as port
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.example.com", 8080));
        return Collections.singletonList(proxy);
    }
    @Override
    public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
        // Custom logic for handling proxy connection failures
        System.out.println("Failed to connect to proxy: " + sa);
    }
}
public class ProxyExamplePS {
    public static void main(String[] args) {
        // Create an instance of MyProxySelector
        MyProxySelector proxySelector = new MyProxySelector();

        // Set the custom proxy selector as the default proxy selector
        ProxySelector.setDefault(proxySelector);

        // Your code here
        // You can now make network connections using the custom proxy selector
        // For example:
        try {
            URL url = new URL("http://www.example.com");
            URLConnection conn = url.openConnection();
            // ...
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

