import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

enum Action {
    Rock,
    Paper,
    Scissors
}

public class RPS
{
    public static void main(String[] args)
    {
        ExecutorService pool = Executors.newCachedThreadPool();

        System.out.println("New game! Players decide actions...");

        try {
            Future<Action> player1Action = pool.submit(new Decider());
            Future<Action> player2Action = pool.submit(new Decider());
        
            while (!(player1Action.isDone() && player2Action.isDone()))
            {
                System.out.print(".");
                TimeUnit.MILLISECONDS.sleep(100);
            }
            int winner = resolveMatch(player1Action.get(), player2Action.get());
            if (winner == 0)
                System.out.println("Draw");
            else
                System.out.println("Winner: Player " + winner);
         }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
    }

    static int resolveMatch(Action a, Action b)
    {
        if (a == Action.Rock && b == Action.Scissors)
            return 1;
        if (a == Action.Scissors && b == Action.Paper)
            return 1; 
        if (a == Action.Paper && b == Action.Rock)
            return 1; 
        if (a == Action.Scissors && b == Action.Rock)
            return 2;
        if (a == Action.Paper && b == Action.Scissors)
            return 2; 
        if (a == Action.Rock && b == Action.Paper)
            return 2; 
        return 0;
    }
    
}

class Decider implements Callable<Action>
{
    public Action call() throws InterruptedException
    {
        TimeUnit.MILLISECONDS.sleep(1000);
        int v = (int) Math.floor(Math.random() * 2);
        if (v == 0)
            return Action.Rock;
        if (v == 1)
            return Action.Paper;
        if (v == 2)
            return Action.Scissors;
        return Action.Rock;
    }
}

class Asker implements Callable<Action>
{
    public Action call() throws InterruptedException
    {
        try (Scanner s = new Scanner(System.in))
        {
            int v = s.nextInt();
            if (v == 0)
                return Action.Rock;
            if (v == 1)
                return Action.Paper;
            if (v == 2)
                return Action.Scissors;
            return Action.Rock;
        }
    }
}