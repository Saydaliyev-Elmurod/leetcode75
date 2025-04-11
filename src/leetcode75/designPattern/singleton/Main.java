package leetcode75.designPattern.singleton;

public class Main {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(String.format("First instance - %s\nSecond instance - %s\nThird instance - %s ", singleton, singleton1, singleton2));
    }
}
