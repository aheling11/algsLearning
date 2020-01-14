package leetcode;

import utils.ListNode;

/**
 * 61 rotateRight
 */
class rotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (k == 0) return head;
        int n = getLength(head);
        k = k%n;
        ListNode pre = head;
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            cur = cur.next;
        }
        while(cur.next != null){
            cur = cur.next;
            pre = pre.next;
        }
        cur.next = head;
        ListNode result = pre.next;
        pre.next = null;
        return result;
    }

    public static int getLength(ListNode l){
        ListNode tmp = l;
        int length = 0;
        while(tmp != null){
            tmp = tmp.next;
            length++;
        }
        return length;
    }
}