package Unit2;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Example1 {
   public static void main(String[] args) {
      try {
         // Create a new InetAddress object for a given hostname
         InetAddress address = InetAddress.getByName("www.facebook.com");

         // Print out the address in string format
         System.out.println(address.toString());
      } catch (UnknownHostException e) {
         // Handle the case where the hostname could not be resolved
         System.err.println("Unable to resolve hostname");
      }
   }
}
