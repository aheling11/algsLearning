package leetcode;


import utils.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

class removeNthFromEnd {


    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode fast = head;
        ListNode slow = head;
        while(n > 0){
            fast = fast.next;
            n--;
        }
        if (fast == null){
            return head.next;
        }

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return head;

    }

    public static void test(){
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= 5; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
//        head = removeNthFromEnd(head, 2);
//        while(head != null){
//
//            System.out.println(head.val);
//            head = head.next;
//        }

        ListNode pre = head;
        ListNode cur = pre;
        while(pre.next == null){
            while(pre.val == cur.val){
                if(cur.next == null){
                    pre.next = null;
                    break;
                }
                cur = cur.next;
            }
            pre.next = cur;
            pre = pre.next;
        }
    }

    public static void main(String[] args) {
        test();
    }
}