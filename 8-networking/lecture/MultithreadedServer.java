import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MultithreadedServer {
    public static void main(String[] args) {
      Thread.setDefaultUncaughtExceptionHandler((Thread t, Throwable e) -> {
       System.err.println(t + " throws exception: " + e);
       e.printStackTrace(System.err);
    }
);
        new Thread(new ServerExample()).start();
        new Thread(new ClientExample("A")).start();
        new Thread(new ClientExample("B")).start();
    }
}

class ClientExample implements Runnable {

    String name;
    ClientExample(String name) {
        this.name = name;
    }

    public void run()
    {
        try (Socket socket = new Socket("localhost", 1234);
                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();
                Scanner scanner = new Scanner(in);
                PrintStream print = new PrintStream(out)) {
            print.println(name);
            print.flush();
            while (true)
                System.out.println(scanner.nextLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ServerExample implements Runnable {
    public void run() {
        try (ServerSocket socket = new ServerSocket(1234)) {
            while(true) {
                Socket client = socket.accept();
                new Thread(new ClientHandler(client)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }
}

class ClientHandler implements Runnable {
    Socket socket;
    ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try (PrintStream out = new PrintStream(socket.getOutputStream());
            Scanner in = new Scanner(socket.getInputStream())) {
            String name = in.nextLine();
            while(true) {
                TimeUnit.SECONDS.sleep(1);
                out.println("Hello " + name);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}