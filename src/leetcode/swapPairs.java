package leetcode;
import utils.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class swapPairs {
    public static ListNode swapPairs(ListNode head) {
        ListNode pre = head;
        ListNode cur = pre.next;
        ListNode dummyhead = head.next;
        ListNode tmp;
        while( cur != null){
            tmp = pre;
            pre.next = cur.next;
            cur.next = pre;
            pre = pre.next;
            if(pre == null){
                break;
            }
            cur = pre.next;
            if(cur == null){
                tmp.next = pre;
            }
            tmp.next = cur;
        }
        return dummyhead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode tmp = head;
        for (int i = 2; i < 4; i++) {
            tmp.next = new ListNode(i);
            tmp = tmp.next;
        }

        tmp = swapPairs(head);
        while(tmp != null){
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }
}