
public class Main {
    public static void main(String[] args) {

        RBTree tree = new RBTree();

        // Test insertion
        System.out.println("Inserting: 10, 20, 30, 40, 50, 25");
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);

        // Print tree structure
        System.out.println("Red-Black Tree structure:");
        tree.printTree();

        // Test search
        System.out.println("Search for 25: " + (tree.search(25) ? "Found" : "Not Found"));
        System.out.println("Search for 60: " + (tree.search(60) ? "Found" : "Not Found"));

        // Test deletion
        System.out.println("\nDeleting 30");
        tree.delete(30);
        System.out.println("Red-Black Tree structure after deletion:");
        tree.printTree();
    }
}