package leetcode75.stack;

public class Main {
    public static void main(String[] args) {
//        DailyTemperatureSolution solution = new DailyTemperatureSolution();
//        solution.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
//        solution.dailyTemperatures(new int[]{30,60,90});


//  Your MyQueue object will be instantiated and called as such:
//        MyQueue obj = new MyQueue();
//        obj.push(1);
//        int param_2 = obj.pop();
//        int param_3 = obj.peek();
//        boolean param_4 = obj.empty();
//        obj.push(4);
//        obj.push(4);
//        obj.push(4);
//        obj.empty();
//        obj.empty();
//        obj.pop();
//        obj.push(4);
//        obj.push(4);
//        obj.pop();

        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.top(); // return 2
        myStack.pop(); // return 2
        myStack.empty();
    }
}
