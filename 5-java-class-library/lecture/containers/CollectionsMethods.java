import java.util.*;

class Solution {
  public static void main(String[] args) {
    List<String> myNames = new ArrayList<String>();

    // Add multiple elements at once using varargs
    Collections.addAll(myNames, "John", "John", "Mary", "Bill");

    // Check frequency of an element
    assert Collections.frequency(myNames, "John") == 2;

    // Find index of a sublist within the full list
    List<String> sublist = new ArrayList<String>();
    Collections.addAll(sublist, "Mary", "Bill");
    assert Collections.indexOfSubList(myNames, sublist) == 2;

    // Print reversed list of names
    Collections.reverse(myNames);
    for (String name : myNames) {
        System.out.println("Hello " + name);
    }
  }
}