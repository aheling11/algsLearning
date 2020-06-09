package Test;


import java.util.Stack;

public class BinaryTree {
    private class TreeNode{
        private int index;
        private double data;
        private TreeNode leftChild;
        private TreeNode rightChild;

        public TreeNode(int index, double data) {
            this.index = index;
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }
    }

    public TreeNode root = null;

    public BinaryTree() {
        root = new TreeNode(1, 50);
    }

    public void preorderTraversal(TreeNode root){
        if (root == null){
            return;
        }
        System.out.println(root.data);
        preorderTraversal(root.leftChild);
        preorderTraversal(root.rightChild);

    }

    public void preorderTraversal_nonrecur(TreeNode root){
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            TreeNode left = cur.leftChild;
            TreeNode right = cur.rightChild;
            if (right != null){
                stack.add(right);
            }
            if (left != null){
                stack.add(left);
            }
            System.out.println(cur.data);
        }
    }

    public void indorderTraversal_nonrecur(TreeNode root){
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.leftChild;
            }
            cur = stack.pop();
            System.out.println(cur.data);
            cur = cur.rightChild;
        }

    }

    public void postdorderTraversal_nonrecur(TreeNode root){
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> list = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            TreeNode left = cur.leftChild;
            TreeNode right = cur.rightChild;
            if (left != null){
                stack.push(left);
            }
            if (right != null){
                stack.push(right);
            }
            list.push(cur);
        }
        while (!list.isEmpty()){
            System.out.println(list.pop().data);
        }
    }

    public boolean contain(TreeNode node, double data){
        if (node == null){
            return false;
        } else if (data < node.data){
            return contain(node.leftChild, data);
        } else if (data > node.data){
            return contain(node.rightChild, data);
        } else {
            return true;
        }
    }
    public boolean Insert(double data) {
        if (contain(root, data)){
            return false;
        } else {
//            root = InsertBST(root, data);
            InsertBST_2(root, data);
            return true;
        }
    }


    public TreeNode InsertBST(TreeNode node, double data){
        if (node == null){
            node = new TreeNode(1, data);
        } else if (data < node.data){
            node.leftChild = InsertBST(node.leftChild, data);
        } else if (data > node.data){
            node.rightChild = InsertBST(node.rightChild, data);
        }
        return node;
    }

    public void InsertBST_2(TreeNode node, double data){

        TreeNode parent = null;
        if (node == null){
            root = new TreeNode(1, data);
        } else {
            while (node != null) {
                if (data < node.data){
                    parent = node;
                    node = node.leftChild;
                } else {
                    parent = node;
                    node = node.rightChild;
                }
            }
            if (data < parent.data){
                parent.leftChild = new TreeNode(1, data);
            } else {
                parent.rightChild = new TreeNode(1, data);
            }
        }

    }

    public void printTree(TreeNode root){
        if (root == null){
            return;
        }


    }

    public void createBinaryTree(){
        for (int i = 0; i < 5; i++) {
//            Insert(Math.random()*50000);
//            Insert(i);
        }
        Insert(5);
        Insert(3);
        Insert(6);
        Insert(2);
        Insert(4);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.createBinaryTree();
//        tree.InsertBST_2(tree.root, 111);
//        tree.indorderTraversal_nonrecur(tree.root);
//        tree.postdorderTraversal_nonrecur(tree.root);
        tree.preorderTraversal_nonrecur(tree.root);
        tree.preorderTraversal(tree.root);
    }

}
