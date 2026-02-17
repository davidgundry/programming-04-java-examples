/**
 * This class demonstrates the syntax for constructor overloading
 */
public class Rock {

    /** This is the default, or no-arg constructor */
    Rock() { }

    // The following are overloaded constructors
    Rock(int i) { }
    Rock(int i, double j) { }
    Rock(double i){ }

    public static void main(String[] args) {
        // Each of these lines constructs a Rock object using a different constructor
        Rock r1 = new Rock();
        Rock r2 = new Rock(1);
        Rock r3 = new Rock(1, 2.5d);
        Rock r4 = new Rock(45.32d);
    }
}
