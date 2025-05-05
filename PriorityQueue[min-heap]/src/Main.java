
public class Main {
    public static void main(String[] args) {


        PriorityQueue q=new PriorityQueue(10);

        q.add(20);
        q.add(30);
        q.add(2);
        q.add(5);
        q.add(7);
        q.add(6);

        q.print();
        System.out.println();
        System.out.println(q.peek());
        q.poll();
        q.poll();
        System.out.println(q.peek());
        q.print();

    }
}