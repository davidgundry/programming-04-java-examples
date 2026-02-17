public class Bird {
    int x;
    Bird(int x) { this.x = x; }
    Bird(int x, int y) { this(x); }

    public static void main(String[] args) {
        // Create a new Bird using the overloaded constructor with two arguments.
        // Internally this calls the constructor with one argument
        Bird b = new Bird(1, 2);
        // We can see that the x value has been set to the first of our arguments
        assert b.x == 1;
    }
}
