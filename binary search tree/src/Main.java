
public class Main {
    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(5);
        tree.insert(6);
        tree.insert(1);
        tree.insert(5);
        tree.insert(6);
        tree.insert(1);
        tree.insert(10);

        tree.printTree(tree.root);
        System.out.println("*********************");
        System.out.println(tree.maxIntree());
        System.out.println(tree.minIntree());
        System.out.println(tree.getHight());
        tree.BFSTraversal();
        System.out.println("**************");
        System.out.println(tree.search(10));
    }
}
