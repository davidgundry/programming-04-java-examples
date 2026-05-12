package _11_generics.lecture._4_shelf;

class Product { }
class Soup extends Product {}
class Rice extends Product {}

/**
 * We can define bounds on type parameters using <code>extends</code>. Here, a <code>Shelf</code>
 * can only be parametrised with a <code>Product</code> and not any other type. We
 * can have a <code>Shelf&lt;Soup&gt;</code> but not a <code>Shelf&lt;Integer&gt;</code>.
 */
public class Shelf<T extends Product> {
    
    public static void main(String[] args) {
        new Shelf<Soup>();
        new Shelf<Rice>();
        // new Shelf<Integer>(); // Bound mismatch: The type Integer is not a valid substitute 
                                 // for the bounded parameter <T extends Product> of the type 
                                 // Shelf<T>Java
    }

}
