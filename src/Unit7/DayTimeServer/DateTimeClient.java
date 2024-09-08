package Unit7.DayTimeServer;

import java.io.*;
import java.net.Socket;

public class DateTimeClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",1234);
            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String Date;
            while((Date=bufferedReader.readLine())!=null){
                System.out.println("Date is "+Date);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
