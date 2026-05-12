package _8_networking.lecture;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class SimpleServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234);){
            System.out.println("Running on port 1234");
            Socket client = serverSocket.accept();
            System.out.println("A client connected");
            PrintWriter writer = new PrintWriter(client.getOutputStream());
            writer.println("Hello, client!");
            writer.flush();
            TimeUnit.SECONDS.sleep(1);
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
}
