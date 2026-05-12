package _6_io.lecture;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new ByteArrayInputStream("123\n12.5".getBytes()))) {
            assert scanner.nextInt() == 123;
            assert scanner.nextFloat() == 12.5f;
        }
    }
}