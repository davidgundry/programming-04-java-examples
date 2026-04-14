import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueExample {
  public static void main(String[] args) {
    Thread.setDefaultUncaughtExceptionHandler((Thread t, Throwable e) -> {
      System.err.println(t + " throws exception: " + e);
      e.printStackTrace(System.err);
    });
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

  public void run() {
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
    BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
    new Thread(new Logger(queue)).start();
    try (ServerSocket socket = new ServerSocket(1234)) {
      while (true) {
        Socket client = socket.accept();
        new Thread(new ClientHandler(client, queue)).start();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    throw new RuntimeException();
  }
}

class ClientHandler implements Runnable {
  Socket socket;
  BlockingQueue<String> queue;

  ClientHandler(Socket socket, BlockingQueue<String> queue) {
    this.socket = socket;
    this.queue = queue;
  }

  public void run() {
    try (PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream())) {
      String name = in.nextLine();
      queue.put(name);
      while (true) {
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

class Logger implements Runnable {
  BlockingQueue<String> queue;

  Logger(BlockingQueue<String> queue) {
    this.queue = queue;
  }

  public void run() {
    while (true) {
      try {
        System.out.println("Server got message " + queue.take());
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}