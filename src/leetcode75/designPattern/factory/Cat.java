package leetcode75.designPattern.factory;

public class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Meow meow");
    }
}
