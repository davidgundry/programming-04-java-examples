package _7_concurrency.lecture;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {
    
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        Future<Integer> result = exec.submit(new MyCalc(1, 1));
        try {
            System.out.println(result.get());  // Blocks until ready
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class MyCalc implements Callable<Integer> {
    int a, b;
    MyCalc(int a, int b) {
        this.a = a; this.b = b;
    }
    public Integer call() {
        return a + b;
    }
}