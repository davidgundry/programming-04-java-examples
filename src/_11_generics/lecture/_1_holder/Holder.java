package _11_generics.lecture._1_holder;

import java.lang.reflect.Array;

public class Holder<T> {
    
    private T[] contents;

    public Holder(Class<T> clazz, int capacity){
        contents = (T[]) Array.newInstance(clazz, capacity);
    }

    public T getElement(int index)
    {
        return contents[index];
    }

    public void setElement(int index, T value)
    {
        contents[index] = value;
    }

}
