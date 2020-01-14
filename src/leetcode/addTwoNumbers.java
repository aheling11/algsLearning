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


/**
 *
 * 根据链表中数据的存储顺序，有两种情况：一是链表按从低位到高位的顺序存储数据，二是按从高位到低位的顺序存储。
 *  情况一：按从低位到高位的顺序存储数据
 *  略
 *  情况二：按从高位到低位的顺序存储
 *  Input: (1 -> 2 -> 3) + (4 -> 5 -> 6)
 *  Output: 5 -> 7 -> 9
 *  Explanation: 123 + 456 = 579
 *  方法一：
 *  1. 计算两个链表的长度
 *  2. 为较短的链表补0，使两个链表长度一样长
 *  3. 采用递归的方法得到结果
 *  4. 判断结果链表首位是否为0，得到最终结果
 */
class addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int n = ListNode.getLength(l1);
        int m = ListNode.getLength(l2);
        ListNode p1 = n <= m ? l1 : l2; // p1 为长度较短的数
        ListNode p2 = n <= m ? l2 : l1;
        for (int i = 0; i < Math.abs(n - m); i++) {
            ListNode newNode = new ListNode(0);
            newNode.next = p1;
            p1 = newNode;
        }
        ListNode result = add(p1, p2);

        return result.val == 0 ? result.next: result;
    }

    private ListNode add(ListNode l1, ListNode l2){
        ListNode result = new ListNode(0);
        if (l1.next == null){
            int sum = l1.val + l2.val;
            if (sum > 9){
                sum -= 10;
                result.val += 1;
            }
            result.next = new ListNode(sum);

        } else {
            ListNode tmp = add(l1.next, l2.next);
            int sum = l1.val + l2.val + tmp.val;
            if (sum > 9){
                sum -= 10;
                result.val += 1;
            }
            tmp.val = sum;
            result.next = tmp;
        }
        return result;
    }
    public static void main(String[] args) {
        //1 9 9
        //0 9 9
        ListNode a = new ListNode(1);
        ListNode.addNewNode(a, 0);
        ListNode.addNewNode(a, 0);
        ListNode.addNewNode(a, 9);
        ListNode b = new ListNode(9);
        ListNode.addNewNode(b, 9);
        ListNode.addNewNode(b, 9);
        ListNode.PrintListNode(a);
        ListNode.PrintListNode(b);
        addTwoNumbers t = new addTwoNumbers();
        ListNode result = t.addTwoNumbers(a, b);
        ListNode.PrintListNode(result);
    }
}