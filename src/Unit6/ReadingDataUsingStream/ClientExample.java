package Unit6.ReadingDataUsingStream;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

//without Buffer reader and writer
public class ClientExample {
    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("localhost",12345);
            InputStream inputStream=clientSocket.getInputStream();
            byte[]bytes= new byte[1024];
            int bytesRead=inputStream.read(bytes);
            String s = new String(bytes,0,bytesRead);
            System.out.println("server says"+s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
