package _6_io.lecture;
import java.io.File;
import java.io.FileFilter;

public class ListJavaFiles {
    public static void main(String[] args) {
        File directory = new File("./");
        FileFilter filter = (File pathname) -> {return pathname.getName().endsWith(".java");};
        File[] files = directory.listFiles(filter);
        if (files != null)
            for (File f : files) {
                System.out.println(f.getName());
            }
    }
}