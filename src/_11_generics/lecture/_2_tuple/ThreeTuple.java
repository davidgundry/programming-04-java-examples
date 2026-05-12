package _11_generics.lecture._2_tuple;

public class ThreeTuple<A, B, C> extends TwoTuple<A,B>
{
    public final C third;
    public ThreeTuple(A a, B b, C c)
    {
        super(a, b);
        third = c;
    }

    public static void main(String[] args)
    {
        Object obj = new Object();
        ThreeTuple<Integer, Float, Object> t = new ThreeTuple<Integer, Float, Object>(new Integer(1), new Float(1.2f), obj);

        Integer a = t.first;
        Float b = t.second;
        Object c = t.third;

        assert(a.intValue() == 1);
        assert(b.floatValue() == 1.2f);
        assert(c == obj);
    }
}


