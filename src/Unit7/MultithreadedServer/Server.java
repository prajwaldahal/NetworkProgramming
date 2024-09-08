package Unit7.MultithreadedServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Server started");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                ClientHandler clientHandler = new ClientHandler(socket);
                clientHandler.start();
                System.out.println("Server is processing....");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
