package Unit2;

import java.net.*;
class Testinet
{
      public static void main(String args[]) throws UnknownHostException
	  {
	//To get and print InetAddress of LocalHost
	InetAddress ad1=InetAddress.getLocalHost();
	System.out.println(ad1);
		//To get and print  InetAddress of Named Host
InetAddress ad2 =InetAddress.getByName("www.microsoft.com");
	System.out.println(ad2);
	//To get and print All InetAddress of Named Host
	InetAddress ad3[]=InetAddress.getAllByName("www.google.com");
	for(int i=0;i<ad3.length;i++)
	{
	System.out.println(ad3[i]);
	}

//To get and print InetAddress of Host with specified IP Address
byte ipAddr[] ={127,0,0,1};
InetAddress ad4 =InetAddress.getByAddress(ipAddr);
System.out.println(ad4);
}
}

