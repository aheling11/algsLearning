package ToOffer;

// Definition for a Node.


import java.util.Stack;

class treeToDoublyList {
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    static Node head, end;
    public static Node treeToDoublyList(Node root) {
        if(root == null) return root;
        process(root);
        end.right = head;
        head.left = end;
        return head;
    }

    //返回最后一个节点
    public static void process(Node root){
        if (root == null) return ;
        process(root.left);
        if (end == null){
            head = root;
            end = root;
        } else {
            end.right = root;
            root.left = end;
            end = root;
        }
        process(root.right);
    }

    public static Node treeToDoublyList_nonrecur(Node root) {
        if (root == null) return root;
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        int flag = 0;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (flag == 0){
                head = cur;
                end = cur;
                flag = 1;
            } else {
                end.right = cur;
                cur.left = end;
                end = cur;
            }
            cur = cur.right;
        }
        end.right = head;
        head.left = end;
        return head;
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(5);
        treeToDoublyList(root);
    }
}