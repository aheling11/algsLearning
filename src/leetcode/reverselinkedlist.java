package leetcode;

import moocZJU.MyTree;
import utils.ListNode;

public class reverselinkedlist {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    ListNode head = null;


    public ListNode reverseList() {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }



    public void printLink(ListNode head) {
        ListNode tmp = head;
        while (tmp != null) {
            System.out.print(tmp.val+" ");
            System.out.println();
            tmp = tmp.next;
        }
    }

    public void addNode(int val) {
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
        reverselinkedlist r = new reverselinkedlist();
        r.addNode(1);
        r.addNode(2);
        r.addNode(3);
        r.addNode(4);
        r.addNode(5);
//        r.printLink();
        r.printLink( r.reverseList());
    }
}
