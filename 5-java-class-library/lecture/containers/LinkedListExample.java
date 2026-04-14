import java.util.*;

class Dog4 { }

class LinkedListExample {  
  static void doSomething(Dog4 d) {}

  public static void main(String[] args) {
    LinkedList<Dog4> list = new LinkedList<>();
    for (int i = 0; i < list.size(); i++) {
        doSomething(list.get(i));
    }

    for (Dog4 element : list)
      doSomething(element);

    Iterator<Dog4> iterator = list.iterator();
    while (iterator.hasNext())
        doSomething(iterator.next());
  }
}