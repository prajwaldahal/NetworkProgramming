package Unit2;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkAddress {
    private String hostname;
    private String ipAddress;

    public NetworkAddress(String hostname, String ipAddress) {
        this.hostname = hostname;
        this.ipAddress = ipAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NetworkAddress)) return false;
        NetworkAddress that = (NetworkAddress) o;
        return hostname.equals(that.hostname) &&
                ipAddress.equals(that.ipAddress);
    }

    @Override
    public int hashCode() {
        int result = hostname.hashCode();
        result = 31 * result + ipAddress.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Hostname: " + hostname + ", IP Address: " + ipAddress;
    }

    public static void main(String[] args) {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            NetworkAddress networkAddress = new NetworkAddress(localHost.getHostName(), localHost.getHostAddress());
            System.out.println(networkAddress.toString());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
