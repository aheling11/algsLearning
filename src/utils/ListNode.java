package utils;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x){
        val = x;
    }

    public static void PrintListNode(ListNode l){
        ListNode tmp = l;
        while(tmp != null){
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
        System.out.println();
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

    public static void addNewNode(ListNode l, int x){
        ListNode tmp = l;
        while(tmp.next != null){
            tmp = tmp.next;
        }
        tmp.next = new ListNode(x);
    }


}
