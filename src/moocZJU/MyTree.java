package moocZJU;

public class MyTree {

    Node head = null;
    private class Node {
        private Object data;
        private Node next;
        private Node(Object data) {
            this.data = data;
        }
    }

    public void addNode(Object data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node t = head;
        while (t.next != null) {
            t = t.next;
        }
        t.next = newNode;
    }

    public Object deleteNode(int index) {
        int i = 1;
        if (head == null || index < 1 || index > length()) {
            return null;
        }
        if (index == i) {
            head = head.next;
            return head.data;
        }
        Node tmp = head;
        Node tmp2;
        while( tmp.next != null ) {
            i++;
            if ( i == index) {
                tmp2 = tmp.next;
                tmp.next = tmp2.next;
                return tmp2.data;
            }
            tmp = tmp.next;

        }
        return null;

    }

    public Object findkth(int k) {
        int i = 1;
        if (k < 1 || k > length()) {
            return null;
        }
        Node tmp = head;
        while ( tmp != null && i<k) {
            i++;
            tmp = tmp.next;
        }
        if ( k == i) {
            return tmp.data;
        } else
        return null;
    }

    public int length() {
        Node tmp = head;
        int size = 0;
        while (tmp != null) {
            size++;
            tmp = tmp.next;
        }
        return size;
    }
    public void printLink() {
        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp.data+" ");
            System.out.println();
            tmp = tmp.next;
        }
    }

    public static void main(String[] args) {
        MyTree temp = new MyTree();
        temp.addNode(1);
        temp.addNode(2);
        temp.addNode(3);
        temp.addNode(4);
        System.out.println(temp.findkth(4));
//        temp.printLink();
//        System.out.println(temp.head.next.data);
    }
}
