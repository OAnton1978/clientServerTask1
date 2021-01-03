package q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket clientSocket = serverSocket.accept(); // ждем подключения, используем блокировку потока т.к. ожидаем подключения клиента и
                                                      // получения от него данных для задачи (процесс идет так: клиент дает данные - получает ответ, потом снова дает данные и т.п.)
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String line = null;
        while ((line = in.readLine()) != "end") {
            // Выход если от клиента получили end
            if (line != null) {
                //Вычисления
                String result = fibonachi(line);
                // Отправляем ответ
                out.println(result);
            }
        }
    }

    public static String fibonachi(String inputSting) {
        long input = Long.parseLong(inputSting);
        long prev = 0;
        long next = 1;
        for (long i = 0; i < input; i++) {
            next = prev + next;
            prev = next - prev;
        }
        return String.valueOf(prev);
    }
}

