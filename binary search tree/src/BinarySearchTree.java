import java.lang.ref.PhantomReference;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    public class Node {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }


    }
     Node root;

    public BinarySearchTree() {
        root=null;
    }

    



    public int search(int num){
        return searchHelper(root,num);
    }
    private int searchHelper(Node root,int num){
        if(root==null){
            System.out.println("number not found");
            return -1;
        }
        if (root.data<num){
            return searchHelper(root.right,num);
        }else if(root.data>num){
            return searchHelper(root.left,num);
        }else {
            System.out.println("number is found ");
            return num;
        }
    }
    public void insert(int num){

        if (root==null){
            Node newNode=new Node(num);
            root=newNode;
        }else {
            insertHelper(root,num);
        }
    }

    private void insertHelper(Node root,int num){

        if(num <= root.data){
            if (root.left==null){
                Node newNode=new Node(num);
                root.left=newNode;

            }else {
                insertHelper(root.left,num);
            }

        }else {
            if (root.right==null){
                Node newNode=new Node(num);
                root.right=newNode;

            }else {
                insertHelper(root.right,num);
            }
        }
    }

    public void delete(int num){
      root=  deleteHelper(root,num);
    }
    private Node deleteHelper(Node root,int num){
        Node temp;
        if (root==null){
            System.out.println("tree is empty or num not exist");

        return root;
        }
        else if (num <root.data){
          root.left= deleteHelper(root.left,num);
        }
        else if (num> root.data) {
            root.right= deleteHelper(root.right,num);
        }
        else {
            if (root.left==null ){
                 temp=root.right;
                root=null;
                return temp;
            }else if ( root.right==null){
                 temp=root.left;
                root=null;
                return temp;
            }
            else {
                int maxNum=this.maxInTreeHelper(root.left);
                root.data=maxNum;
                root.left=deleteHelper(root.left,maxNum);

            }
        }
        return root;
    }
    public int maxIntree(){
            return maxInTreeHelper(root);
    }
    private int maxInTreeHelper(Node root){
        if (root.right==null){
            return root.data;
        }
       return maxInTreeHelper(root.right);
    }

    public int minIntree(){
        return minInTreeHelper(root);
    }
    private int minInTreeHelper(Node root){
        if (root.left==null){
            return root.data;
        }
        return minInTreeHelper(root.left);
    }




    public  void printTree(Node root) {
        printTreeHelper(root, 0);
    }

    private  void printTreeHelper(Node node, int depth) {
        if (node == null) {
            return;
        }

        // Print right subtree with indentation
        printTreeHelper(node.right, depth + 1);

        // Print current node value with indentation
        for (int i = 0; i < depth; i++) {
            System.out.print("    ");
        }
        System.out.println(node.data);

        // Print left subtree with indentation
        printTreeHelper(node.left, depth + 1);
    }

    public int getHight( ){

        if (root==null){
            return -1;
        }else {
            return getightHelper(root);
        }

    }

    private int getightHelper(Node root){

        if (root ==null){
            return -1;
        }
        int left_subTree=getightHelper(root.left);
        int right_subTree=getightHelper(root.right);

        return 1+ Math.max(left_subTree,right_subTree);

    }

    public void DFSpreOrder(){
        preOrderHelper(root);
    }
    public void preOrderHelper(Node root){

        if (root != null){
            System.out.print(root.data+" ");
            preOrderHelper(root.left);
            preOrderHelper(root.right);
        }else {
            return;
        }
    }

    public void DFSinOrder(){
       inOrderHelper(root);
    }
    public void inOrderHelper(Node root){

        if (root != null){
            inOrderHelper(root.left);
            System.out.print(root.data+" ");
            inOrderHelper(root.right);
        }else {
            return;
        }

    }

    public void DFSpostOrder(){
        postOrderHelper(root);
    }
    public void postOrderHelper(Node root){

        if (root != null){
            postOrderHelper(root.left);
            postOrderHelper(root.right);
            System.out.print(root.data+" ");

        }else {
            return;
        }
    }

    public void BFSTraversal(){
        BFSTraversalHelper(root);
    }

    private void BFSTraversalHelper(Node root) {
        if (root==null){return;}
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()){
                Node current=queue.poll();
            System.out.print(current.data+" ");
            if (current.left !=null){
                queue.add(current.left);
            }
            if(current.right !=null){
                queue.add(current.right);
            }
        }


    }

}
