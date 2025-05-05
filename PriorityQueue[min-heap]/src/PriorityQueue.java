/// min heap
public class PriorityQueue {

    private int []heap;
    private int size;
    private int capacity;

    public PriorityQueue( int capacity) {
        this.heap =new int [capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    private int parent_index(int index){
        return (index-1)/2;
    }

    private int leftChild_index(int index){
        return index*2+1;
    }
    private int rightChild_index(int index){
        return index*2+2;
    }

    private void swap(int index_1,int index_2){
        int temp=heap[index_1];
        heap[index_1]=heap[index_2];
        heap[index_2]=temp;

    }

    public void add(int data){
        if (size>=capacity){
            throw new IllegalStateException("Priority queue is full");
        }
        heap[size]=data;
        size++;
        heapifyUp(size-1);
    }

    private void heapifyUp(int index) {
        if (index <= 0) {
            return;
        }
        int parentIndex=parent_index(index);
        if (heap[parentIndex]>heap[index]){
            swap(index,parentIndex);
            heapifyUp(parentIndex);
        }
    }


    public int poll(){
        if (size == 0) {
            throw new IllegalStateException("Priority queue is empty");
        }
        int data=heap[0];
        heap[0]=heap[size-1];
        size--;
        heapifyDown(0);
        return data;
    }

    private void heapifyDown(int index) {
        int smallest = index;
        int leftChildIndex = leftChild_index(index);
        int rightChildIndex = rightChild_index(index);

        if (leftChildIndex < size && heap[leftChildIndex] < heap[smallest]) {
            smallest = leftChildIndex;
        }

        if (rightChildIndex < size && heap[rightChildIndex] < heap[smallest]) {
            smallest = rightChildIndex;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }

    }

    public boolean isEmpty() {
        return size == 0;
    }
    public void print(){
        for (int i=0;i<size;i++){
            System.out.print(heap[i]+" ");
        }

    }

    public int peek() {
        if (size == 0) {
            throw new IllegalStateException("Priority queue is empty");
        }
        return heap[0];
    }


}
