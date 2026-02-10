// App.java
public class App {
    public static void main(String[] args) {
        Dog[] dogs = new Dog[3];
        dogs[0] = new Dog("Fido");
        dogs[1] = new Dog("Elvis");
        dogs[2] = new Dog("Peanut");
        
        for (Dog d: dogs)
            System.out.println(d.getName());
    }
}