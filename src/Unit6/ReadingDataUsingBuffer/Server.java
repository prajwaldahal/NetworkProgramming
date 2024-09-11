package Unit6.ReadingDataUsingBuffer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class Server{
	public static void main(String[] args){
		try (ServerSocket server = new ServerSocket(1234)) {
			System.out.println("swerver started");
			Socket client=server.accept();
			PrintWriter wr= new PrintWriter(client.getOutputStream(),true);
			//BufferedWriter wr= new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			wr.println("hello how are you");
			//wr.flush();
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}