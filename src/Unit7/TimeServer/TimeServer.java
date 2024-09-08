package Unit7.TimeServer;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeServer {
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
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a"); //
                String formattedTime = sdf.format(date);
                printWriter.println(formattedTime);
                clientSocket.close();
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
