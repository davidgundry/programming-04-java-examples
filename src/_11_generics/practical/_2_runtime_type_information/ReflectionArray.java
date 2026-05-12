package _11_generics.practical._2_runtime_type_information;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;

public class ReflectionArray {
    public static void main(String[] args) {
        // Create a list of Objects
        LinkedList<HasDefaultConstructor> objs = new LinkedList<HasDefaultConstructor>();
        objs.push(new A());
        objs.push(new B());
        objs.push(new C());

        // For each object, clone it using the default (no-arg constructor)
        // We know it has a no-arg constror because it extends HasDefaultConstructor
        LinkedList<HasDefaultConstructor> clones = new LinkedList<HasDefaultConstructor>();
        for (HasDefaultConstructor obj : objs) {
            Class<? extends HasDefaultConstructor> cls = obj.getClass();
            try {
                clones.push(cls.getDeclaredConstructor().newInstance());
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }

        // For each clone, check the type and print the appropriate field
        for (HasDefaultConstructor obj : clones) {
            if (obj instanceof A)
                System.out.println(((A)obj).a);
            if (obj instanceof B)
                System.out.println(((B)obj).b);
            if (obj instanceof C)
                System.out.println(((C)obj).c);
        }

    }
}

// As our other methods extend this, we are guaranteed to have a default
// (no-arg) constructor
class HasDefaultConstructor {
    public HasDefaultConstructor() {}
}

class A extends HasDefaultConstructor {
    public String a = "a";
}

class B extends HasDefaultConstructor {
    public String b = "b";
}

class C extends HasDefaultConstructor {
    public String c = "c";
}