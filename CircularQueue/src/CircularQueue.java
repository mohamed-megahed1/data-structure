public class CircularQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int []queue;
    private int currentSize;

    public CircularQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front=0;
        this.rear =-1;
        this.queue=new int[maxSize];
        this.currentSize = 0;
    }

    public void enqueue(int data){

        if (isFull()){
            System.out.println("the q is full");
            return;
        }
        rear = (rear + 1) % maxSize;
        queue[rear]=data;
        currentSize++;
    }
    public int dequeue(){
        if (isEmpty()){
            System.out.println("q is already empty ");
            throw new RuntimeException("Queue underflow");
        }
        int data= queue[front];
        front = (front + 1) % maxSize;
        currentSize--;
        return data;

    }
    public int peek(){
        if (isEmpty()){
            System.out.println("q is already empty ");
            throw new RuntimeException("Queue underflow");
        }
        return queue[front];
    }


    // Check if the queue is empty
    public boolean isEmpty() {
        return currentSize == 0;
    }

    // Check if the queue is full
    public boolean isFull() {
        return currentSize == maxSize;
    }

    // Get the current size of the queue
    public int size() {
        return currentSize;
    }

}
