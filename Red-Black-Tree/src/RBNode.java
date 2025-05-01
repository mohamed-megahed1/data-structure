public class RBNode {
    int data;
    boolean isRed;
    RBNode left,right,parent;

    public RBNode(int data) {
        this.data = data;
        this.isRed = true;
        this.left = this.right =  this.parent=null;

    }
}
