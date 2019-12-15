package leetcode;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }

}

public class LinkedListCycle {
    static ListNode head = null;

    /**
     * hash表
     * @param head
     * @return
     */
    public static boolean hasCycle_hash(ListNode head) {
        HashMap<ListNode, Integer> hashMap = new HashMap<>();
        ListNode tmp = head;
        while (tmp != null) {
            if (!hashMap.containsKey(tmp)){
                hashMap.put(tmp, 1);
                tmp = tmp.next;
            } else {
                return true;
            }
        }
        return false;
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null ||head.next.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode quick = head.next;
        while (slow != null && quick.next != null){
            if (slow == quick) {
                return true;
            }
            slow = slow.next;
            quick = quick.next.next;
        }
        return false;
    }


    public static void addNode(int data) {
        ListNode node = new ListNode(data);
        if (head == null){
            head = node;
            return;
        }
        ListNode tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = node;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{};
        int pos = 1;
        for (int i = 0; i < arr.length; i++) {
            addNode(arr[i]);
        }

        ListNode tmp = head;
        System.out.println("Linked List:");
//        while (tmp.next != null){
//            tmp = tmp.next;
//        }
//        ListNode tail = head;
//        for (int i = 0; i < 2; i++) {
//            tail = tail.next;
//        }
//        tmp.next = tail;
//        while (tmp != null){
//            System.out.print(tmp.val + " ");
//            tmp = tmp.next;
//        }
        System.out.println(hasCycle(head));
        System.out.println();


    }
}