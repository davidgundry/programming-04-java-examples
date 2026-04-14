public class Threads {
    public static void main(String[] args)
    {
        Problem problem = new Problem();

        Thread f = new Thread(new CalcF(problem));
        Thread g = new Thread(new CalcG(problem));
        Thread h = new Thread(new CalcH(problem));

        f.start();
        g.start();
        h.start();

        try {
            f.join();
            g.join();
            h.join();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        int result = problem.f + problem.g + problem.h;
        System.out.println(result);
    
    }
}

class Problem
{
    public int f;
    public int g;
    public int h;
}

class ProblemCalculation
{
    protected Problem problem;
    public ProblemCalculation(Problem problem)
    {
        this.problem = problem;
    }
}

class CalcF extends ProblemCalculation implements Runnable {
    public CalcF(Problem problem) {
        super(problem);
    }

    public void run() {
        synchronized(problem)
        {
            problem.f = 1;
        }
    }
}

class CalcG extends ProblemCalculation  implements Runnable {
    public CalcG(Problem problem) {
        super(problem);
    }

    public void run() {
        problem.g = 1;
    }
}

class CalcH extends ProblemCalculation implements Runnable {
    public CalcH(Problem problem) {
        super(problem);
    }

    public void run() {
        problem.h = 1;
    }
}