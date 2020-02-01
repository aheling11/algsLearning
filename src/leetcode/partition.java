package leetcode;

import utils.ListNode;

/**
 * 86. 分隔链表
 * 本题有两种解法，
 *
 */
class partition {
    public static ListNode partition(ListNode head, int x) {
        if (head == null){
            return null;
        }
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;
        ListNode tmp = dummyhead;
        ListNode cur = head;
        ListNode pre = tmp;
        int count = 0;
        while(tmp.next != null){
            if (tmp.next.val >= x){
                pre = tmp;
                cur = tmp.next;
                break;
            }
            count++;
            tmp = tmp.next;
        }
        int cnt = 0;
        tmp = dummyhead;
        while(tmp.next != null ){
            if (tmp.next.val < x && cnt >= count){
                ListNode tnext = tmp.next.next;
                pre.next = tmp.next;
                tmp.next.next = cur;
                tmp.next = tnext;
                pre = pre.next;
            } else {
                tmp = tmp.next;
            }
            cnt++;
        }
        return dummyhead.next;
    }

    public static ListNode partition1(ListNode head, int x){
        ListNode minNode = new ListNode(0);
        ListNode maxNode = new ListNode(0);
        ListNode t = minNode;
        ListNode tmax = maxNode;
        ListNode tmp = head;
        while(tmp != null){
            ListNode newNode = new ListNode(tmp.val);
            if (tmp.val < x){
                minNode.next = newNode;
                minNode = minNode.next;
            } else {
                maxNode.next = newNode;
                maxNode = maxNode.next;
            }
            tmp = tmp.next;
        }
        minNode.next = tmax.next;
        return t.next;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode.addNewNode(head,1);
        ListNode.addNewNode(head,4);
        ListNode.addNewNode(head,1);
        ListNode.addNewNode(head,3);
        ListNode.addNewNode(head,2);
        ListNode.addNewNode(head,5);
//        ListNode.addNewNode(head,2);
        ListNode partition = partition1(head, 3);
        ListNode.PrintListNode(partition);
    }
}