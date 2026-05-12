package _7_concurrency.lecture;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorExample {
  public static void main(String[] args) {
    ExecutorService single = Executors.newCachedThreadPool();
    single.submit(new TaskA());
    single.submit(new TaskB());

    try (Scanner s = new Scanner(System.in)) {
      while (true)
        System.out.println(s.nextLine());
    }
  }
}

class TaskA implements Runnable {
  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println("Task A: " + i);
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

class TaskB implements Runnable {
  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println("Task B: " + i);
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}