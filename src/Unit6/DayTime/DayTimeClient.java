package Unit6.DayTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class DayTimeClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("time.nist.gov",13);
        readUsingStream(socket);
        readUsingBuffered(socket);
    }

    private static void readUsingBuffered(Socket socket) throws IOException {
        InputStreamReader inputStreamReader=new InputStreamReader(socket.getInputStream());
        BufferedReader reader= new BufferedReader(inputStreamReader);
        String s;
        while((s=reader.readLine())!=null){
            System.out.println(s);
        }
        socket.close();
    }

    private static void readUsingStream(Socket socket) throws IOException {
        InputStream in = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = in.read(bytes);
        System.out.println(new String(bytes, 0, len));

    }
}
