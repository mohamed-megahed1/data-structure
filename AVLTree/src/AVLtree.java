public class AVLtree {

    private Node root;

    private int height(Node node){
        if (node==null){
            return 0;
        }else {
            return node.height ;
        }
    }
    private int getBalance(Node node){
        if (node==null){
            return 0;
        }else {
            return height(node.leftChild)-height(node.rightChild) ;
        }
    }

    void updateHeight(Node node) {
        if (node != null) {
            node.height = Math.max(height(node.leftChild), height(node.rightChild)) + 1;
        }
    }

    Node rightRotation(Node node){

        Node temp=node.leftChild;
        Node temp2=temp.rightChild;

        temp.rightChild=node;
        node.leftChild=temp2;

        updateHeight(node);
        updateHeight(temp);
        return temp;

    }

    Node leftRotation(Node node){

        Node temp=node.rightChild;
        Node temp2=temp.leftChild;

        temp.leftChild=node;
        node.rightChild=temp2;

        updateHeight(node);
        updateHeight(temp);
        return temp;

    }



    public void insert(int data){
        root=insert(root,data);

    }

    private Node insert(Node root, int data) {
        if (root==null){
           return new Node(data);
        }

        if (root.data<data){
            root.rightChild=insert(root.rightChild,data);
        } else if (root.data>data) {
            root.leftChild=insert(root.leftChild,data);
        }else {
            return root;
        }

        updateHeight(root);
        int balance=getBalance(root);

        if (balance <-1 && data > root.rightChild.data ){
            return leftRotation(root);
        }

        if (balance > 1 && data < root.leftChild.data ){
            return rightRotation(root);
        }

        if (balance <-1 && data< root.rightChild.data){
            root.rightChild=rightRotation(root.rightChild);
            return leftRotation(root);
        }

        if (balance > 1 && data > root.leftChild.data){
            root.rightChild=leftRotation(root.rightChild);
            return rightRotation(root);
        }
        return root;
    }

    public void delete(int data) {
        root = delete(root, data);
    }

    private Node delete(Node root, int data) {

        Node temp;
        if (root==null){

            return root;
        } else if (root.data>data) {
            root.leftChild=delete(root.leftChild,data);
        } else if (root.data<data) {
            root.rightChild=delete(root.rightChild,data);
        }else {
            if (root.leftChild==null){
                temp=root.rightChild;
                root=null;
                return temp;
            } else if (root.rightChild==null){
                temp=root.leftChild;
                root=null;
                return temp;
            }else {
                int maxNum=this.maxInTreeHelper(root.leftChild);
                root.data=maxNum;
                root.leftChild=delete(root.leftChild,maxNum);
            }

        }
        if (root == null) return root;

        updateHeight(root);
        int balance=getBalance(root);

        if (balance <-1 && data > root.rightChild.data ){
            return leftRotation(root);
        }

        if (balance > 1 && data < root.leftChild.data ){
            return rightRotation(root);
        }

        if (balance <-1 && data< root.rightChild.data){
            root.rightChild=rightRotation(root.rightChild);
            return leftRotation(root);
        }

        if (balance > 1 && data > root.leftChild.data){
            root.rightChild=leftRotation(root.rightChild);
            return rightRotation(root);
        }
        return root;

    }

    public int maxIntree(){
        return maxInTreeHelper(root);
    }
    private int maxInTreeHelper(Node root){
        if (root.rightChild==null){
            return root.data;
        }
        return maxInTreeHelper(root.rightChild);
    }

    public int minIntree(){
        return minInTreeHelper(root);
    }
    private int minInTreeHelper(Node root){
        if (root.leftChild==null){
            return root.data;
        }
        return minInTreeHelper(root.leftChild);
    }

    void inOrder(Node node) {
        if (node != null) {
            inOrder(node.leftChild);
            System.out.print(node.data + " ");
            inOrder(node.rightChild);
        }
    }

    Node search(Node node, int data) {
        if (node == null || node.data == data) return node;

        if (data < node.data)
            return search(node.leftChild, data);
        return search(node.rightChild, data);
    }
    public void inOrder() {
        inOrder(root);
        System.out.println();
    }
    public boolean search(int data) {
        return search(root, data) != null;
    }
}
