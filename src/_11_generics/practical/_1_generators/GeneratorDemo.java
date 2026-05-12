package _11_generics.practical._1_generators;

public class GeneratorDemo {
    public static void main(String[] args) {
        Generator<? extends Coffee> g = Espresso.makeEspresso();
        generate(g);
        // generate(Tea.generator()); //! Compilation error
    }

    static void generate(Generator<? extends Coffee> g)
    {
        for (int i=0;i<10;i++)
            System.out.println(g.next().toString());
    }
}


interface Generator<T> {
    T next();
}

class Coffee {
    public static Generator<Coffee> generator() {
        return () -> { return new Coffee(); };
    }
    public String toString() { return "Coffee!"; }
}

class Espresso extends Coffee {
    public static Generator<Espresso> makeEspresso() {
        return () -> { return new Espresso(); };
    }
    public String toString() { return "Espresso!"; }
}

class Tea {
    public static Generator<Tea> generator() {
        return () -> { return new Tea(); };
    }
    public String toString() { return "Tea!"; }
}