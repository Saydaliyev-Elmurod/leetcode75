package leetcode75.stack;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class MyStack {
    Queue<Integer> queue;
    Queue<Integer> reversedQueue;


    public MyStack() {
        queue = new LinkedList<>();
        reversedQueue = new LinkedList<>();
    }

    public void push(int x) {
        if (queue.isEmpty()) queue.add(x);
        else {
            while (!queue.isEmpty()) {
                reversedQueue.add(queue.poll());
            }
            queue.add(x);
            while (!reversedQueue.isEmpty()) {
                queue.add(reversedQueue.poll());
            }
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
