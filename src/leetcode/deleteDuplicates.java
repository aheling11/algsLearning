package leetcode;

import utils.ListNode;

import java.util.HashMap;


/**
 *
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 * 方法一：
 * 遍历一遍链表将数字出现的次数存入hash表。
 * 在遍历一遍链表根据hash表删除重复元素
 * 很慢
 *
 **/
class deleteDuplicates {

    public static ListNode deleteDuplicateshash(ListNode head) {
        if (head == null){
            return null;
        }
        if (head.next == null){
            return head;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode tmp = head;
        while(tmp != null){
            if (!map.containsKey(tmp.val)){
                map.put(tmp.val, 1);
            } else {
                map.put(tmp.val, 2);
            }
            tmp = tmp.next;
        }
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;
        ListNode pre = dummyhead;
        ListNode cur = head;
        while(cur != null){
            if (map.get(cur.val) == 2){
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = pre.next;
                cur = cur.next;
            }

        }
        return dummyhead.next;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        if (head.next == null){
            return head;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode.addNewNode(a, 2);
        ListNode.addNewNode(a, 2);
        ListNode.addNewNode(a, 2);
        ListNode.addNewNode(a, 3);
        ListNode.addNewNode(a, 4);
        a = deleteDuplicates(a);
        ListNode.PrintListNode(a);
    }
}