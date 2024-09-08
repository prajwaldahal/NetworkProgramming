package Unit8.HalfDuplex;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            byte[] buffer = new byte[1024];
            InetAddress inetAddress=InetAddress.getLocalHost();
            int port=1234;
            Scanner scanner=new Scanner(System.in);
            while(true){
                System.out.print("Enter the message to sent to  server: ");
                String msg=scanner.nextLine();
                byte[] msgByte = msg.getBytes();
                DatagramPacket datagramPacket=new DatagramPacket(msgByte,msgByte.length,inetAddress,port);
                socket.send(datagramPacket);
                DatagramPacket recievePacket=new DatagramPacket(buffer,buffer.length);
                socket.receive(recievePacket);
                String s=new String(recievePacket.getData(),0,recievePacket.getLength());
                System.out.println("Recieved: "+s);
            }
        } catch (SocketException | UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
