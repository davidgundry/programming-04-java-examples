import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

public class PrintingToFile {
    public static void main(String[] args) {
        try (Writer writer = new BufferedWriter(new FileWriter("fileA.txt"));
                OutputStream outputStream = new FileOutputStream("fileB.txt")) {
            writer.write("✨".toCharArray());
            outputStream.write("✨".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}