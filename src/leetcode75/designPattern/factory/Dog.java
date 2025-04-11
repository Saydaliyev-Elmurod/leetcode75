package leetcode75.designPattern.factory;

public class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("WOWF!");
    }
}
