package ToOffer;

import utils.TreeNode;

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class isSubStructure {
    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null){
            return false;
        }
        boolean result = false;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(A);
        while (!stack.isEmpty() && !result){
            TreeNode cur = stack.pop();
            TreeNode leftNode = cur.left;
            TreeNode rightNode = cur.right;
            if (rightNode != null){
                stack.add(rightNode);
            }
            if (leftNode != null){
                stack.add(leftNode);
            }
            if (cur.val == B.val){
                result = DoesAHaveB(cur, B);
            }
        }
        return result;
    }

    public static boolean isSubStructure_recur(TreeNode A, TreeNode B) {
        if (A == null || B == null){
            return false;
        }
        boolean result = false;
        if (A.val == B.val){
            result = DoesAHaveB(A, B);
        }
        if (!result) result = isSubStructure(A.left, B);
        if (!result) result = isSubStructure(A.right, B);
        return result;
    }




    public static boolean DoesAHaveB(TreeNode A, TreeNode B){
        if (B == null){
            return true;
        }
        if (A == null){
            return false;
        }
        if (A.val != B.val){
            return false;
        }
        return DoesAHaveB(A.left, B.left) && DoesAHaveB(A.right, B.right);

    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode(3);
        A.left = new TreeNode(4);
        A.right = new TreeNode(5);
        A.left.left = new TreeNode(1);
        A.left.right = new TreeNode(2);
        TreeNode B = new TreeNode(3);
        B.left = new TreeNode(4);
        B.right = new TreeNode(5);

        boolean result = isSubStructure_recur(A,B);
        System.out.println(result);


    }
}