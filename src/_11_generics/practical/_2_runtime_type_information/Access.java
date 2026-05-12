package _11_generics.practical._2_runtime_type_information;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Access {
    public static void main(String[] args) throws Exception {
        Secret s = new Secret();
        for (Method m : s.getClass().getDeclaredMethods())
        {
            try {
                System.out.println("Invoking " + m.getName());
                ArrayList<Object> params = new ArrayList<Object>();
                for (Class<?> c : m.getParameterTypes())
                {
                    System.out.println("Expects " + c.getName());
                    params.add(c.getDeclaredConstructor().newInstance());
                }
                m.setAccessible(true);
                m.invoke(s, params.toArray());
            } catch (InvocationTargetException e) {}
            catch (NoSuchMethodException e) {}
        }
    }
}

class Secret
{
    private void secretMethod() { System.out.println("You got me.");}

    private void secretMethod2(String arg) { System.out.println("You got me again. " + arg);}
}