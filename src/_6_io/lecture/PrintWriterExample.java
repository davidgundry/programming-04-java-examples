package _6_io.lecture;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterExample {
    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(
                                new File("./data/myfile.txt"))))) {
            out.println("✨");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}