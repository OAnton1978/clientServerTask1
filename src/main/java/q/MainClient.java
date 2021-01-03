package q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MainClient {
    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int port = 8080;
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Введите число либо end для выхода");
                String inputMan = scanner.nextLine();
                // Выход если от клиента получили end
                if (inputMan == "end") {
                    break;
                }
                out.println(inputMan);
                String resultClient = in.readLine();
                System.out.println(resultClient);
            }
        }
    }
}

