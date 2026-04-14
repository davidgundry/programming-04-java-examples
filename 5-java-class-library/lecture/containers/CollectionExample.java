import java.util.*;
                
class MyObject {}

class CollectionExample {  
  public static void main(String[] args) {
    Collection<MyObject> myList = new ArrayList<MyObject>();
    MyObject objectA = new MyObject();

    myList.add(new MyObject());
    myList.add(objectA);
    assert myList.size() == 2;
    assert myList.contains(objectA);

    myList.remove(objectA);
    assert !myList.contains(objectA);

    myList.clear();
    assert myList.size() == 0;
    assert myList.isEmpty();
  }
}