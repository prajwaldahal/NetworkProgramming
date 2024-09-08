package Unit6.ReadingDataUsingStream;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerExample {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket=new ServerSocket(1234);
            Socket clientSocket=serverSocket.accept();
            OutputStream outputStream=clientSocket.getOutputStream();

            Scanner sc = new Scanner(System.in);

            String msg = sc.nextLine();

            outputStream.write(msg.getBytes());

            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
