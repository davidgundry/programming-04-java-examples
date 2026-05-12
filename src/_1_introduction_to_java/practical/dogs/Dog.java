package _1_introduction_to_java.practical.dogs;

// Dog.java
public class Dog {
    private String name;

    Dog(String name) {
        this.name = name;
    }

    String getName() { return this.name; }

    void setName(String name) { this.name = name; }
}