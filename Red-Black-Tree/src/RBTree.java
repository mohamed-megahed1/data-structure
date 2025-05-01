public class RBTree {

    private RBNode root;
    private static final RBNode NIL = new RBNode(0);
    static {
        NIL.isRed = false; // NIL nodes are black
        NIL.left = NIL.right = NIL.parent = null;
    }


    RBTree() {
        root = NIL;
    }

    private void leftRotate(RBNode x) {
        RBNode y=x.right;
        x.right=y.left;

        if (y.left!=NIL){
            y.left.parent = x;
        }
        y.parent=x.parent;
        
        if (x.parent==null){
            root=y;
        } else if (x==x.parent.left) {
            x.parent.left = y;
        }else {
            x.parent.right = y;
        }
        y.left=x;
        x.parent=y;
    }

    private void rightRotate(RBNode x) {
        RBNode y=x.left;
        x.left=y.right;

        if (y.right!=NIL){
            y.right.parent = x;
        }
        y.parent=x.parent;

        if (x.parent==null){
            root=y;
        } else if (x==x.parent.right) {
            x.parent.right = y;
        }else {
            x.parent.left = y;
        }
        y.right=x;
        x.parent=y;
    }

    public void insert(int data) {
        RBNode z = new RBNode(data);
        RBNode y = null;
        RBNode x = root;
        while (x != NIL) {
            y = x;
            if (data < x.data) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.parent=y;
        if (y==null){
            root=z;
        } else if (data < y.data) {
            y.left=z;
        }else {
            y.right=z;
        }
        z.left=NIL;
        z.right = NIL;


        fixInsert(z);
    }

    private void fixInsert(RBNode z) {

        while ( z.parent !=null && z.parent.isRed  ){
            if (z.parent.parent.left==z.parent){
                RBNode uncle= z.parent.parent.right;
                if (uncle.isRed){ //case 2 :uncle is red
                    z.parent.isRed=false;
                    uncle.isRed=false;
                    z.parent.parent.isRed=true;
                }else {
                    // case 3 :uncle is black
                    if(z==z.parent.right){ //z is right child
                        z=z.parent;
                        leftRotate(z);
                    }
                    z.parent.isRed=false;
                    z.parent.parent.isRed=true;
                    rightRotate(z.parent.parent);
                }

            }
            else {

                RBNode u = z.parent.parent.left;
                if (u.isRed) {

                    z.parent.isRed = false;
                    u.isRed = false;
                    z.parent.parent.isRed = true;
                    z = z.parent.parent;
                } else {

                    if (z == z.parent.left) {

                        z = z.parent;
                        rightRotate(z);
                    }

                    z.parent.isRed = false;
                    z.parent.parent.isRed = true;
                    leftRotate(z.parent.parent);
                }
            }

        }
        root.isRed=false;
    }



    private RBNode minimum(RBNode node) {
        while (node.left != NIL) {
            node = node.left;
        }
        return node;
    }

    public boolean search(int data) {
        return searchNode(data) != null;
    }
    private RBNode searchNode(int data) {
        RBNode node = root;
        while (node != NIL && node.data != data) {
            if (data < node.data) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node == NIL ? null : node;
    }

    private void transplant(RBNode u, RBNode v) {
        if (u.parent == null) {
            root = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        v.parent = u.parent;
    }



    // Delete a node with given data
    public void delete(int data) {
        RBNode targetNode = searchNode(data);
        if (targetNode == null) return;

        RBNode y = targetNode;
        boolean originalColor = y.isRed;
        RBNode x;

        if (targetNode.left == NIL) {
            x = targetNode.right;
            transplant(targetNode, targetNode.right);
        } else if (targetNode.right == NIL) {
            x = targetNode.left;
            transplant(targetNode, targetNode.left);
        } else {
            y = minimum(targetNode.right);
            originalColor = y.isRed;
            x = y.right;
            if (y.parent == targetNode) {
                x.parent = y;
            } else {
                transplant(y, y.right);
                y.right = targetNode.right;
                y.right.parent = y;
            }
            transplant(targetNode, y);
            y.left = targetNode.left;
            y.left.parent = y;
            y.isRed = targetNode.isRed;
        }

        if (!originalColor) {
            fixDelete(x);
        }
    }

    // Fix violations after deletion
    private void fixDelete(RBNode x) {
        while (x != root && !x.isRed) {
            if (x == x.parent.left) {
                RBNode sibl = x.parent.right;
                if (sibl.isRed) {
                    sibl.isRed = false;
                    x.parent.isRed = true;
                    leftRotate(x.parent);
                    sibl = x.parent.right;
                }
                if (!sibl.left.isRed && !sibl.right.isRed) {
                    sibl.isRed = true;
                    x = x.parent;
                } else {
                    if (!sibl.right.isRed) {
                        sibl.left.isRed = false;
                        sibl.isRed = true;
                        rightRotate(sibl);
                        sibl = x.parent.right;
                    }
                    sibl.isRed = x.parent.isRed;
                    x.parent.isRed = false;
                    sibl.right.isRed = false;
                    leftRotate(x.parent);
                    x = root;
                }
            } else {
                RBNode s = x.parent.left;
                if (s.isRed) {
                    s.isRed = false;
                    x.parent.isRed = true;
                    rightRotate(x.parent);
                    s = x.parent.left;
                }
                if (!s.right.isRed && !s.left.isRed) {
                    s.isRed = true;
                    x = x.parent;
                } else {
                    if (!s.left.isRed) {
                        s.right.isRed = false;
                        s.isRed = true;
                        leftRotate(s);
                        s = x.parent.left;
                    }
                    s.isRed = x.parent.isRed;
                    x.parent.isRed = false;
                    s.left.isRed = false;
                    rightRotate(x.parent);
                    x = root;
                }
            }
        }
        x.isRed = false;
    }




    public void printTree() {
        if (root == NIL) {
            System.out.println("Tree is empty");
            return;
        }
        printTree(root, "", true);
    }

    private void printTree(RBNode node, String prefix, boolean isLeft) {
        if (node == NIL) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + "NIL");
            return;
        }

        String color = node.isRed ? "R" : "B";
        System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.data + "(" + color + ")");

        String newPrefix = prefix + (isLeft ? "│   " : "    ");

        printTree(node.left, newPrefix, true);
        printTree(node.right, newPrefix, false);
    }


}
