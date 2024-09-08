package Unit7.MultithreadedServer;

import java.io.*;
import java.net.Socket;

public class ClientHandler extends Thread {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
             BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter pw = new PrintWriter(socket.getOutputStream(), true)
        ) {

            String input;
            while ((input = br.readLine()) != null) {
                try {
                    int number = Integer.parseInt(input);
                    boolean isPrime = checkPrime(number);
                    pw.println(number + (isPrime ? " is prime" : " is not prime"));
                } catch (NumberFormatException e) {
                    pw.println("Invalid number format.");
                }
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean checkPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i <= num/2; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
