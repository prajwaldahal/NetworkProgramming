package Unit7.MultithreadedServer;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 1234);
             Scanner scanner = new Scanner(System.in);
             PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            while (true) {
                System.out.print("Enter the number: ");
                int number = scanner.nextInt();
                printWriter.println(number);
                System.out.println(bufferedReader.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
