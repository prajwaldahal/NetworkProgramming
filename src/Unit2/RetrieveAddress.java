package Unit2;

import java.net.*;
import java.util.*;
class RetrieveAddress{
	public static void main(String[]args)throws UnknownHostException{
		
		InetAddress localAddress = InetAddress.getLocalHost();
        System.out.println(localAddress);
        System.out.println("my address is "+localAddress.getHostAddress());
        System.out.println("my hostname is "+localAddress.getHostName());
        System.out.println("my IP address is "+Arrays.toString(localAddress.getAddress()));
		
		InetAddress inetAddress = InetAddress.getByName("www.kcmit.edu.np");
		System.out.println(inetAddress.toString());
		
		InetAddress [] inetAddresses = Inet4Address.getAllByName("www.facebook.com");
		for(InetAddress address:inetAddresses){
			System.out.println(address.toString());
		}
		
		byte[] addresses ={(byte)120,(byte)255,(byte)78,(byte)34};
		InetAddress inetAddressA=InetAddress.getByAddress(addresses);
		System.out.println(inetAddressA.toString());
	}
}