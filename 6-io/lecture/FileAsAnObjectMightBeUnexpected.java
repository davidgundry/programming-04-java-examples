import java.io.File;
import java.io.IOException;

class FileAsAnObjectMightBeUnexpected {
    public static void main(String[] args)
    {
        File a = new File("a.txt");
        System.out.println(a.exists()); //  false
        doSomethingNotInvolvingA();
        System.out.println(a.exists()); //  true!?
    }

    static void doSomethingNotInvolvingA()
    {
        File b = new File("a.txt");
        try {
            b.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}