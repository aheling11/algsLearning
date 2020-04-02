package ToOffer;

import java.util.ArrayList;
import java.util.HashMap;

class copyRandomList {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Node dhead = new Node(head.val);
        Node tmp = head;
        HashMap<Node, Node> hash = new HashMap<>();
        hash.put(head, dhead);
        while (tmp.next != null){
            if (!hash.containsKey(tmp.next)){
                Node newNode = new Node(tmp.next.val);
                hash.put(tmp.next, newNode);
            }
            dhead.next = hash.get(tmp.next);
            if(tmp.random != null){
                if (!hash.containsKey(tmp.random)){
                    Node newNode = new Node(tmp.random.val);
                    hash.put(tmp.random, newNode);
                }
                dhead.random = hash.get(tmp.random);
            } else {
                dhead.random = null;
            }
            dhead = dhead.next;
            tmp = tmp.next;
        }
        dhead.random = hash.get(tmp.random);
        return hash.get(head);
    }

    public static Node copyRandomList_1(Node head) {
        if (head == null) return head;
        Node cur = head;
        Node nxt = null;
        //保存下一个原始节点，并在当前节点后插入新节点
        while (cur != null){
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }
        cur = head;
        while (cur != null){
            cur.next.random = (cur.random != null ? cur.random.next : null);
            cur = cur.next.next; //下一个节点原始节点
        }
        cur = head.next;
        Node p_origin = head;
        Node result = head.next;
        while (p_origin != null){
            p_origin.next = p_origin.next.next;
            cur.next = cur.next != null ? cur.next.next : null;
            p_origin = p_origin.next;
            cur = cur.next;
        }
        return result;
    }


    public static void main(String[] args) {
        int[] arr = {7,13,11,10,1};
        Node root = new Node(arr[0]);
        Node cur = root;
        for (int i = 1; i < arr.length; i++) {
            Node newnode = new Node(arr[i]);
            cur.next = newnode;
            cur = newnode;
        }
        cur = root;
        cur.random = null;
        cur = cur.next;
        cur.random = root;
        cur = cur.next;
        cur.random = root.next.next.next.next;
        cur = cur.next;
        cur.random = root.next.next;
        cur = cur.next;
        cur.random = root;
        cur = root;
        while (cur != null){
            System.out.print(cur.val);
            System.out.print(" ");
            if (cur.random != null){
                System.out.println(cur.random.val);
            } else {
                System.out.println("null");
            }
            cur = cur.next;
        }
        copyRandomList_1(root);
    }
}