package _11_generics.lecture._5_wildcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Fruit {}
class Apple extends Fruit {}

public class Wildcards {
    public static void main(String[] args) {
        //ArrayList<Fruit> f = new ArrayList<Apple>(); // Type mismatch: cannot convert from ArrayList<Apple> to ArrayList<Fruit>

        ArrayList<Fruit> f = new ArrayList<Fruit>();
        f.add(new Fruit());

        ArrayList<Apple> apples = new ArrayList<Apple>();
        apples.add(new Apple());
        ArrayList<? extends Fruit> f2 = apples;
        f2.get(0);
        //f2.add(new Apple()); // The method add(capture#1-of ? extends Fruit) in the type ArrayList<capture#1-of ? extends Fruit> is not applicable for the arguments (Apple)

        List<Number> numbers = Arrays.asList(1, 2, 3);
        consumeNumbers(numbers);

        List<Integer> integers = Arrays.asList(1, 2, 3);
        // consumeNumbers(integers); // The method consumeNumbers(List<Number>) in the type Wildcards is not applicable for the arguments (List<Integer>)
        consumeNumbersOrSubclasses(integers);
    }


    static void consumeNumbers(List<Number> list) {
        list.get(0);
        list.add(new Integer(1));
    }

    static void consumeNumbersOrSubclasses(List<? extends Number> list) {
        list.get(0);
        // list.add(new Integer(1)); // The method add(capture#2-of ? extends Number) in the type List<capture#2-of ? extends Number> is not applicable for the arguments (Integer)
    }
}
