package _6_io.lecture;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class CreatingNewFiles {
    public static void main(String[] args) {
        File directory = new File("./data");
        String suffix = ".md";
        FileFilter filter = (File pathname) -> {return pathname.getName().endsWith(suffix);};
        File[] files = directory.listFiles(filter);
        if (files != null)
            for (File f : files) {
                String baseFileName = f.getName().substring(0, f.getName().length() - suffix.length());
                try {
                    new File(directory, baseFileName + ".html").createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }
}