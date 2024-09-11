package Unit6.ReadingDataUsingBuffer;

import java.io.*;
import java.net.*;
public class Client {
    public static void main(String[]args) throws IOException{
        Socket client= new Socket("localhost",1234);
        BufferedReader br = new BufferedReader(
                new InputStreamReader(client.getInputStream())
        );
        String value;
        while((value=br.readLine())!=null){
            System.out.println(value);
        }
    }
}
