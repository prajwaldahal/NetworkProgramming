package Unit2;

import java.io.*;
import java.net.*;
public class INAE {
	public static void main(String[] args) {
		try {
 			InetAddress address = InetAddress.getByName("www.kCmit.edu.np");
			System.out.println("Host name: " + address.getHostName()); 
			System.out.println("IP address: " + address.getHostAddress());
			System.out.println("Is reachable? " + address.isReachable(5000));
		} 
		catch (UnknownHostException e) {
		System.err.println("Could not find host"); }
		catch (IOException e) {
		System.err.println("Error checking reachability"); }
		} } 
