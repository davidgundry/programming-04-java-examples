import java.io.File;

public class TheFileClass {
    public static void main(String[] args) {
        File file = new File("path/to/myFile.txt");
        System.out.println("Name:" + file.getName());
        System.out.println("Read: " + file.canRead());
        System.out.println("Write: " + file.canWrite());
        System.out.println("Execute: " + file.canExecute());
        System.out.println("Absolute Path: " + file.getAbsolutePath());
        System.out.println("Parent: " + file.getParent());
    }
}