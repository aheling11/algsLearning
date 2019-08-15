package moocZJU;

public class singleLink {

    Node head = null;

    private class Node{
        private Object data;
        private Node next;
        public Node(Object data) {
            this.data = data;
        }
    }


    // 增加新节点
    public void addNode(Object data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = newNode;
    }

    //删除节点
    public void deleteNode(int k) {
        if (k < 1 || k > this.length()) {
            System.out.println("index超过边界");
            return ;
        }

        Node t;
        if (k == 1) {
            if( head != null) head = head.next;
            else return;
        }

        Node p = this.findKth(k-1);
        if (p == null) {
            System.out.println(k-1+"为null");
        } else if (p.next == null) {
            System.out.println(k+"为null");
        } else {
            t = p.next;
            p.next = t.next;
        }



    }


    //查找节点
    public Node findKth(int k) {
        if (k < 1 || k > this.length()) {
            return null;
        }
        int i = 1;
        Node tmp = head;

        while (tmp != null && i < k) {
            i++;
            tmp = tmp.next;
        }
        if (k == i) return tmp;
        else return null;


    }
    //访问节点
    public Object get(int k) {
        if (k < 1 || k > this.length()) {
            return null;
        }
        int i = 1;
        Node tmp = head;

        while (tmp != null && i < k) {
            i++;
            tmp = tmp.next;
        }
        if (k == i) return tmp.data;
        else return null;


    }
    public int length() {

        int length = 0;
        Node tmp = head;
        while (tmp != null) {
            tmp = tmp.next;
            length ++;
        }
        return length;
    }




    public static void main(String[] args) {
        singleLink slink = new singleLink();
        slink.addNode(5);
        slink.addNode(6);
        slink.addNode(7);
//        System.out.println(slink.length());
        System.out.println(slink.get(1));
        System.out.println(slink.get(2));
        System.out.println(slink.get(3));
        slink.deleteNode(2);
        System.out.println(slink.get(1));
        System.out.println(slink.get(2));
        System.out.println(slink.get(4));
    }



}
