package leetcode75.stack;

public class MyCircularQueueMain {
    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(3);
// ["MyCircularQueue","enQueue","enQueue",
// "enQueue","enQueue","Rear",
// "isFull","deQueue","enQueue","Rear"]
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.Rear();
        queue.isFull();
        queue.deQueue();
        queue.enQueue(3);
        queue.Rear();


    }
}
