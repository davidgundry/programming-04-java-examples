public class InitialisationDemo {
    boolean b;  // false
    boolean b2 = true;
    MyObject myObj;  // null
    MyObject myObj2 = new MyObject();

    double x;
    double y = f(x);
    double f(double x) { return x + 1; }

    static {
        System.out.println("Demo class is accessed");
    }

    {
        System.out.println("Demo is being initialised");
    }

    InitialisationDemo() {
        System.out.println("Demo constructor is run");
    }

    public static void main(String[] args) {
        System.out.println("main method started");
        InitialisationDemo demo = new InitialisationDemo();
        System.out.println("Value of y: " + demo.y);
    }
}

class MyObject {}