package _11_generics.lecture._3_stack;

import java.util.ArrayList;

public class ArrayListBackedStack<T> implements Stack<T>{

    ArrayList<T> list = new ArrayList<T>();

    @Override
    public void push(T item) {
        list.add(item);
    }

    @Override
    public T pop() {
        return list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        class Cat {}
        Cat myCat = new Cat();
        Stack<Cat> cats = new ArrayListBackedStack<Cat>();
        Stack<Cat> moarCats = new LinkedListBackedStack<Cat>();

        cats.push(myCat);
        assert(cats.pop() == myCat);
    }
}
