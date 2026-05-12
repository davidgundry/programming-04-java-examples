package _6_io.lecture;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class MyObject implements Serializable  {
    String message;
}

public class SerialisatonExample {

    public static void main(String[] args) {

        MyObject myObject = new MyObject();
        myObject.message = "Hello!";

        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("file.data"))) {
            out.writeObject(myObject);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("file.data"))) {
            MyObject myObjectLoaded = (MyObject) in.readObject();
            System.out.println(myObjectLoaded.message);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}