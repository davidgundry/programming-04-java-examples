package _8_networking.lecture;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SimpleClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 1234);
            Scanner scanner = new Scanner(socket.getInputStream()))
        {
            System.out.println("The server responded:");
            System.out.println(scanner.nextLine());
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
