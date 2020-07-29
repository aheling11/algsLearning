package leetcode;

import utils.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class mergeKLists {
    /**
     * 时间复杂度O(NK)，N为总节点数，K为要合并的链表个数
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length < 1) {
            return null;
        }
        ListNode dhead = new ListNode(-1);
        ListNode cur = dhead;
        while (true) {
            ListNode minNode = null;
            int minPoint = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null){
                    continue;
                }
                if (minNode == null || lists[i].val < minNode.val) {
                    minPoint = i;
                    minNode = lists[i];
                }
            }
            if (minPoint == -1){
                break;
            }
            cur.next = minNode;
            cur = cur.next;
            lists[minPoint] = lists[minPoint].next;
        }
        return dhead.next;
    }

    public static ListNode mergeKLists_2(ListNode[] lists){
        Queue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for(ListNode node : lists){
            while (node != null){
                queue.add(node);
                node = node.next;
            }
        }
        ListNode dhead = new ListNode(-1);
        ListNode cur = dhead;
        while (!queue.isEmpty()){
            cur.next = new ListNode(queue.poll().val);
            cur = cur.next;
        }
        return dhead.next;
    }

    public static ListNode mergeKLists_3(ListNode[] lists){
        Queue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for(ListNode node : lists){
            if (node != null){
                queue.add(node);
            }
        }
        ListNode dhead = new ListNode(-1);
        ListNode cur = dhead;
        while (!queue.isEmpty()){
            ListNode node = queue.poll();
            if (node.next != null) queue.add(node.next);
            cur.next = new ListNode(node.val);
            cur = cur.next;
        }
        return dhead.next;
    }



    public static void main(String[] args) {
        ListNode a = new ListNode(-2);
        ListNode c = a;
        int[] list = new int[]{-1,-1,-1};
        for (int i = 0; i < 3; i++) {
            a.next = new ListNode(list[i]);
            a = a.next;
        }
        ListNode b = null;
        ListNode[] lists = new ListNode[2];
        lists[0] = c;
        lists[1] = b;
        ListNode cur = mergeKLists_2(lists);
        while (cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}