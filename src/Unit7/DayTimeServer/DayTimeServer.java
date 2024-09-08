package Unit7.DayTimeServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DayTimeServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server started");
            while (true){

                    Socket clientSocket = serverSocket.accept();
                    System.out.println("Client connected");
                    OutputStream outputStream = clientSocket.getOutputStream();
                    PrintWriter printWriter = new PrintWriter(outputStream,true);
                    Date date = new Date();
                    printWriter.println(date);
                }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
