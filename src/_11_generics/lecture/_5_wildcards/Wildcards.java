package _11_generics.lecture._5_wildcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Fruit {}
class Apple extends Fruit {}

/**
 * Demonstrates use of wildcard in generics, including <?> and <? extends X>.
 */
public class Wildcards {
    public static void main(String[] args) {
        //ArrayList<Fruit> f = new ArrayList<Apple>(); // Type mismatch: cannot convert from ArrayList<Apple> to ArrayList<Fruit>

        ArrayList<Fruit> fruit = new ArrayList<Fruit>();
        fruit.add(new Fruit());

        ArrayList<Apple> apples = new ArrayList<Apple>();
        apples.add(new Apple());
        ArrayList<? extends Fruit> appleFruit = apples;
        appleFruit.get(0);
        //appleFruit.add(new Apple()); // The method add(capture#1-of ? extends Fruit) in the type ArrayList<capture#1-of ? extends Fruit> is not applicable for the arguments (Apple)

        List<Number> numbers = Arrays.asList(1, 2, 3);
        consumeNumbers(numbers);

        List<Integer> integers = Arrays.asList(1, 2, 3);
        // consumeNumbers(integers); // The method consumeNumbers(List<Number>) in the type Wildcards is not applicable for the arguments (List<Integer>)
        consumeNumbersOrSubclasses(integers);

        consumeObjects(numbers);
    }


    static void consumeNumbers(List<Number> list) {
        list.get(0);
    }

    static void consumeNumbersOrSubclasses(List<? extends Number> list) {
        list.get(0);
        // list.add(new Integer(1)); // The method add(capture#2-of ? extends Number) in the type List<capture#2-of ? extends Number> is not applicable for the arguments (Integer)
    }

    static void consumeObjects(List<?> list)
    {
        // We can pass any List due to the wildcard type parameter <?>
        // But we only know that items in list are subclasses of Object.
    }
}
