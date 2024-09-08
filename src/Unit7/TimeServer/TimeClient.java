package Unit7.TimeServer;

import java.io.*;
import java.net.Socket;

public class TimeClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",1234);
            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String time;
            while((time=bufferedReader.readLine())!=null){
                System.out.println("time is "+time);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
