public class StringTemplates
{
    public static void main(String[] args)
    {
        // To run this in JDK 21, you need to enable preview features:
        //     javac --enable-preview --release 21 .\StringTemplates.java
        //     java --enable-preview StringTemplates
        int version = 21;
        System.out.println(STR."This requires version \{version}.");
    }
}