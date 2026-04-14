import java.util.*;
                
class Dog { }

class ArrayListExample {  
  public static void main(String[] args) {
    List<Dog> dogs = new ArrayList<Dog>();
    dogs.add(new Dog());

    // The following all run in O(1)
    assert !dogs.isEmpty();
    dogs.set(0, new Dog());
    Dog myDog = dogs.get(0);
    assert dogs.size() == 1;

    // Resizing the ArrayList is expensive
    dogs.add(new Dog());
  }
}