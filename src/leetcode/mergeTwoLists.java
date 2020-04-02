package leetcode;

import utils.ListNode;

public class mergeTwoLists {



    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoLists_iter(ListNode l1, ListNode l2) {
        ListNode dhead = new ListNode(0);
        ListNode prev = dhead;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        if (l1 != null){
            prev.next = l1;
        }
        if (l2 != null){
            prev.next = l2;
        }
        return dhead.next;
    }

    public void printLink(ListNode head) {
        ListNode tmp = head;
        while (tmp != null) {
            System.out.print(tmp.val+" ");
            System.out.println();
            tmp = tmp.next;
        }
    }

    public void addNode(int val, ListNode head) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode t = head;
        while (t.next != null) {
            t = t.next;
        }
        t.next = newNode;
    }
    public static void main(String[] args) {
        mergeTwoLists r = new mergeTwoLists();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);

        r.addNode(2, l1);
        r.addNode(4, l1);
//        r.addNode(5, l1);
//        r.addNode(6, l1);
////
        r.addNode(3, l2);
        r.addNode(4, l2);

//        r.printLink(r.mergeTwoLists_iter(l1, l2));
        long a = -2147483648;
        a = 7;
        if( (a & 1) == 0){

        }
        System.out.println(Long.toBinaryString(a));
        System.out.println(Long.toBinaryString(~a));
        System.out.println(a & 1);
        System.out.println(~(a-1));
    }

}
