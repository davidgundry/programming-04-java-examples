package _11_generics.lecture._3_stack;

import java.util.LinkedList;

public class LinkedListBackedStack<T> implements Stack<T>{

    LinkedList<T> list = new LinkedList<T>();

    @Override
    public void push(T item) {
        list.push(item);
    }

    @Override
    public T pop() {
        return list.pop();
    }
}
