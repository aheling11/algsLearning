package ToOffer;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class pathSum {
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Stack<Integer> stack = new Stack<>();
        int[] cursum = new int[1];
        help(root, sum, cursum, result, stack);
        return result;
    }

    private static void help(TreeNode root, int sum, int[] cursum, List<List<Integer>> result, Stack<Integer> stack) {
        if (root == null){
            return;
        }
        stack.push(root.val);
        cursum[0] += root.val;
        if (cursum[0] == sum && root.left == null && root.right == null){
            result.add(new ArrayList<>(stack));
        }
        help(root.left, sum, cursum, result, stack);
        help(root.right, sum, cursum, result, stack);
        cursum[0] -= stack.pop();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        pathSum(root, 22);
    }

}