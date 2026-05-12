package _11_generics.lecture._0_class;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Thingy { 
    private void secretMethod() {}
}

/**
 * Demonstrates working with Class objects that contain runtime type information.
 */
public class ClassObject {

    public static void main(String[] args) {
        // .class lets us statically reference a Class object for a type
        listMethods(Thingy.class);

        Thingy a = new Thingy();
        System.out.println("\n"+a);
        try {
            Thingy b = newInstanceOfObject(a);
            System.out.println(b);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
    }

    /**
     * Prints information about the methods available on a class to System.out.

     * 
     * This demonstrates that runtime type information gives us access to private methods,
     * including invoking private methods outside of their protection domain. One use of this
     * is to aid in writing unit tests. But is is best avoided if at all possible.
     * 
     * @param clazz Class object to inspect
     */
    public static void listMethods(Class<?> clazz)
    {
        // Method[] methods = clazz.getMethods();
        Method[] methods = clazz.getDeclaredMethods(); // Methods _declared_ on this class, including private methods
        System.out.println("Methods on Thingy class:");
        for (Method method : methods)
        {
            System.out.println("\t" + method);

            // if we had an instance of the object, we could also invoke the private method:
            // method.setAccessible(true);
            // method.invoke(instance);
        }
    }

    /**
     * Create a new instance of the same class as an object by invoking the default constructor on its Class object.
     * This assumes the object has a no-arg constructor. If there is no no-arg constructor, it will throw a NoSuchMethodException.
     * 
     * @param <T> the type of the object to construct
     * @param prototype the prototype object to use
     * @return a new instance of the same class as `prototype`
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws SecurityException
     */
    public static <T> T newInstanceOfObject(T prototype) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Class<?> c = prototype.getClass();
        return (T) c.getDeclaredConstructor().newInstance();
    }
}
