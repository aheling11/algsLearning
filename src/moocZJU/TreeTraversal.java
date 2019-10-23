package moocZJU;

public class TreeTraversal {

    public class Node {
        int data = 0;
        Node left;
        Node right;
        Node(int data){this.data = data;}

    }

    Node root = new Node(0);

//    public void init() {
//        Node tnode = root;
//        for (int i = 0; i < 10; i++) {
//            addNode(tnode, i);
//            tnode = tnode.left;
//        }
//    }

    public void preOrder(Node node){
        if (node == null) return;
        System.out.println(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void addNode(Node rnode, int data) {
        Node node = new Node(data);
        if (rnode == null) {
            rnode.data = node.data;
        } else if (rnode.left == null) {
            rnode.left = node;
        } else if (root.right == null) {
            rnode.right = node;
        } else {
            addNode(rnode.left, data);
        }
    }

    public static void main(String[] args) {
        TreeTraversal t = new TreeTraversal();
        t.addNode(t.root,1);
        t.addNode(t.root,2);
        t.addNode(t.root,3);
        t.addNode(t.root,4);
        t.preOrder(t.root);
    }
}
