package leetcode;

import utils.ListNode;

public class mergeTwoLists {



    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        if (curr1 == null) {
            return curr2;
        } else if (curr2 == null) return curr1;

        while (curr1!=null && curr2!=null) {
            ListNode newNode1 = curr1.next;
            ListNode newNode2 = curr2.next;
            if (curr1.val == curr2.val) {
                curr1.next = curr2;
                curr1 = newNode1;
            } else if (curr1.val < curr2.val){
                curr1.next = curr2;
                curr1 = newNode1;
            } else {
                curr2.next = curr1;
                curr2 = newNode2;
            }

            if (newNode1 == null) {
                curr1.next = curr2;
                break;
            } else if (newNode2 == null){
                curr2.next = curr1;
                break;
            }
        }



        return l1.val <= l2.val ? l1 : l2;


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

        r.printLink(r.mergeTwoLists(l1, l2));
    }

}
