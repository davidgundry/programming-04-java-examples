package _6_io.lecture;
import java.io.File;

public class ProcessFiles {

    interface Strategy {
        void process(File file);
    }

    private Strategy strategy;

    public ProcessFiles(Strategy strategy) {
        this.strategy = strategy;
    }

    public void process(File directory) {
        File[] files = directory.listFiles();
        if (files != null)
            for (File f : files) 
                strategy.process(f);
    }

    public static void main(String[] args) {
        new ProcessFiles(new PrintNameStrategy()).process(new File("./data"));
    }
}

class PrintNameStrategy implements ProcessFiles.Strategy {
    public void process(File file) {
        System.out.println(file.getName());
    }
}