public class Node {

     int data,height;
     Node rightChild;
     Node leftChild;

    Node(int data) {
        this.data = data;
        this.height = 1;
        this.leftChild =this.rightChild=null;

    }
}
