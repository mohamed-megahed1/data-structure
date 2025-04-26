import com.sun.source.tree.Tree;

public class Main {
    public static void main(String[] args) {


        AVLtree tree = new AVLtree();


        System.out.println("Inserting: 10, 20, 30, 40, 50, 25");
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);

        System.out.print("Inorder traversal after insertion: ");
        tree.inOrder();


        System.out.println("Search for 25: " + (tree.search(25) ? "Found" : "Not Found"));
        System.out.println("Search for 60: " + (tree.search(60) ? "Found" : "Not Found"));


        System.out.println("Deleting 30");
        tree.delete(30);
        System.out.print("Inorder traversal after deletion: ");
        tree.inOrder();



    }
}