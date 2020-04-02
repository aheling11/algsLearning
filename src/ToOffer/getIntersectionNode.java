package ToOffer;

import utils.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class getIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        int lenA = 0;
        int lenB = 0;
        while (tempA != null){
            tempA = tempA.next;
            lenA++;
        }
        while (tempB != null){
            tempB = tempB.next;
            lenB++;
        }
        tempA = lenA > lenB ? headA : headB;
        tempB = tempA == headA ? headB : headA;
        int n = Math.abs(lenA - lenB);
        for (int i = 0; i < n; i++) {
            tempA = tempA.next;
        }
        while (tempA != null){
            if (tempA == tempB){
                return tempA;
            }
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return null;
    }

    public static void main(String[] args) {

    }

}