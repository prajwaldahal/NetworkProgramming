import java.io.*;
import java.net.*;
import java.util.*;

class TestINM {
	public static void main(String[] args)
		throws UnknownHostException
	{

		InetAddress address1
			= InetAddress.getByName("142.250.193.110");
		InetAddress address2
			= InetAddress.getByName("45.22.30.39");
		InetAddress address3
			= InetAddress.getByName("172.217.163.174");

		// true
		System.out.println(
			"Is Address-1 equals to Address-2? : "
			+ address1.equals(address2));
		// false
		System.out.println(
			"Is Address-1 equals to Address-3? : "
			+ address1.equals(address3));

		// returns IP address
		System.out.println("IP Address : "
						+ address1.getHostAddress());
		// returns host name,
		// which is same as IP
		// address in this case
		System.out.println(
			"Host Name for this IP Address : "
			+ address1.getHostName());

		// returns address in bytes
		System.out.println("IP Address in bytes : "
						+ address1.getAddress());

		// false, as the given site
		// has only one server
		System.out.println("Is this Address Multicast? : "
						+ address1.isMulticastAddress());

		System.out.println("Address in string form : "
						+ address1.toString());

		// returns fully qualified
		// domain name for this IP address.
		System.out.println(
			"Fully qualified domain name for this IP address : "
			+ address1.getCanonicalHostName());

		// hashcode for this IP address.
		System.out.println("Hashcode for this IP address : "
						+ address1.hashCode());

		// to check if the InetAddress is
		// an unpredictable address..
		System.out.println(
			"Is the InetAddress an unpredictable address? : "
			+ address1.isAnyLocalAddress());
	}
}
