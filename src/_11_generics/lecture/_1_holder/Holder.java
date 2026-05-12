package _11_generics.lecture._1_holder;

import java.lang.reflect.Array;

/**
 * Demonstrates a basic generic container class. The backing array might either be
 * of the generic type <T> or Object. At runtime these are the same, as type
 * erasure means T[] is erased to Object[]. However, there are differences in
 * constructing the array as we cannot instantiate a generic type (i.e. new T[capacity]).
 * We have to use runtime type information via the Class<T> parameter.
 * 
 * As the array is encapsulated within this class, it would be simpler to use an
 * Object[] and up/downcast whenever we remove/add elements. (See commented out code)
 */
public class Holder<T> {
    
    private T[] contents;
    // private Object[] upcastContents;

    public Holder(Class<T> clazz, int capacity){
        contents = (T[]) Array.newInstance(clazz, capacity);
        //upcastContents = new Object[capacity];
    }

    public T getElement(int index)
    {
        return contents[index];
        // return (T) upcastContents[index];
    }

    public void setElement(int index, T value)
    {
        contents[index] = value;
        //upcastContents[index] = value;
    }

}
