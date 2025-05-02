
public class Main {
    public static void main(String[] args) {


        CircularQueue queue = new CircularQueue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);
        System.out.println("Front element: " + queue.peek());
        System.out.println("Queue size: " + queue.size());
        queue.enqueue(70);
        System.out.println("Front element: " + queue.peek());
        System.out.println("Queue size: " + queue.size());
        queue.dequeue();
        System.out.println("Front element: " + queue.peek());
        System.out.println("Queue size: " + queue.size());
        queue.dequeue();
        System.out.println("Front element: " + queue.peek());
        System.out.println("Queue size: " + queue.size());
        queue.dequeue();
        System.out.println("Front element: " + queue.peek());
        System.out.println("Queue size: " + queue.size());
        queue.dequeue();
        System.out.println("Front element: " + queue.peek());
        System.out.println("Queue size: " + queue.size());

    }
}