import java.util.*;

class Animal { }
class Dog3 extends Animal { }
class Cat extends Animal { }

class NonGenericContainer {
    Object[] contents = new Object[2];
    Object get(int i) { return contents[i]; }
    Object set(int i, Object value) { return contents[i] = value; }
}

class SolutionUsingNonGenericContainer {  
    public static void main(String[] args) {
        NonGenericContainer ngc = new NonGenericContainer();
        ngc.set(0, new Dog3());
        ngc.set(1, new Cat());
        Dog3 myDog = (Dog3) ngc.get(0);
        Dog3 myOtherDog = (Dog3) ngc.get(1); // Oops! This is not a dog!
    }
}
                
class SolutionUsingGenericContainer {  
  public static void main(String[] args) {
    List<Dog3> dogs = new ArrayList<Dog3>();
    dogs.add(new Dog3());
    Dog3 myDog = dogs.get(0);  // No need to downcast!
  
    List<Cat> cats = new ArrayList<Cat>();
    cats.add(new Cat());
    // cats.add(new Dog3()); // compiler error
  }
}