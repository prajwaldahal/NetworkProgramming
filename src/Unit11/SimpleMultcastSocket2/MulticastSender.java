package Unit11.SimpleMultcastSocket2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class MulticastSender {
    public static void main(String[] args) {
        try{
            MulticastSocket socket = new MulticastSocket(4444);
            InetAddress inetAddress=InetAddress.getByName("224.0.0.1");
            Scanner scanner = new Scanner(System.in);
           while(true){
               System.out.println("Enter the message to sent: ");
               String msg =scanner.nextLine();
               byte[]msgByte=msg.getBytes();
               DatagramPacket sendPacket= new DatagramPacket(msgByte,msgByte.length,inetAddress,4444);
               socket.send(sendPacket);
           }
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
