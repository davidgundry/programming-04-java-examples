package _11_generics.practical._2_runtime_type_information;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection {
    public static void main(String[] args) {
        try {
            Class<?> cls = Class.forName("_11_generics.practical._2_runtime_type_information.Demo");
            System.out.println(cls.getName());
            for (Field f : cls.getFields())
                System.out.println(f.toString());
            for (Method f : cls.getMethods())
                System.out.println(f.toString());
        }
        catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}

class Demo {
    public int x;
    public int y;
    public void myMethod() {}
}
