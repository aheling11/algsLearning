package leetcode;

import utils.ListNode;

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class reverseBetween {

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null){
            return head;
        }
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;
        ListNode pre = dummyhead;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next; // cur的值不会变
        for (int i = m; i < n; i++) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;

        }
        return dummyhead.next;

    }
    public static ListNode reverseBetween_stack(ListNode head, int m, int n) {
        if (head == null){
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;
        ListNode pre = dummyhead;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        for (int i = m; i <= n; i++) {
            stack.push(cur);
            cur = cur.next;
        }
        ListNode t = stack.pop();
        pre.next = t;
        while (!stack.empty()){
            t.next = stack.pop();
            t = t.next;
        }
        t.next = cur;
        return dummyhead.next;

    }

    public static void main(String[] args) {
        ListNode head= new ListNode(1);
        ListNode.addNewNode(head, 2);
        ListNode.addNewNode(head, 3);
        ListNode.addNewNode(head, 4);
        ListNode.addNewNode(head, 5);
        head = reverseBetween(head, 1, 5);
        ListNode.PrintListNode(head);
    }
}