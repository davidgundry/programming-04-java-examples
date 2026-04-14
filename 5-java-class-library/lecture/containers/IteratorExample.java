import java.util.*;

class Dog2 {
  boolean isGoodBoy() { return true; }
}

class IteratorExample {  
  public static void main(String[] args) {
    Collection<Dog2> dogs = new ArrayList<Dog2>();
    Collections.addAll(dogs, new Dog2(), new Dog2(), new Dog2());

    Iterator<Dog2> it = dogs.iterator();
    while(it.hasNext()) {
        Dog2 dog = it.next();
        if (dog.isGoodBoy()) {
            System.out.println("Good dog!");
            it.remove();
        }
    }
  }
}