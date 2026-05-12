package _5_java_class_library.lecture._1_containers;
import java.util.*;

class Dog5 { }

public class StackImplementation {  
  public static void main(String[] args) {
    Stack<Dog5> dogs = new Stack<Dog5>();
    Dog5 d = new Dog5();
    dogs.push(d);
    assert dogs.peek() == d;
    Dog5 d2 = dogs.pop();
    assert dogs.empty();
  }
}

class Stack<T> { 
  private LinkedList<T> list = new LinkedList<T>();

  public void push(T element) { list.addFirst(element); }
  public T peek() { return list.getFirst(); }
  public T pop() { return list.removeFirst(); }
  public boolean empty() { return list.isEmpty();}
}

