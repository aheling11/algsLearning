package leetcode;


import java.util.HashSet;

import static utils.Utils.printArray;

/**
105. Construct Binary Tree from Preorder and Inorder Traversal
 * Definition for a binary tree node.
 **/


class buildTreeByPreAndIn {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    int[] preorder;
    int[] inorder;
    public TreeNode buildTreeByPreAndIn(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        this.preorder = preorder;
        this.inorder = inorder;
        return help(0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode help(int pStart, int pEnd, int iStart, int iEnd){

        TreeNode root = new TreeNode(this.preorder[pStart]);
        if(pStart > pEnd || iStart > iEnd) {
            return root;
        }
        int inPos = findIndex(root.val, iStart, iEnd);
        int leftlength = inPos - iStart;
        if (leftlength != 0){
            root.left = help(pStart + 1, pStart + leftlength, iStart, inPos - 1);
        }
        if ( iEnd - inPos != 0) {
            root.right = help(pStart + leftlength + 1, pEnd, inPos + 1, iEnd);
        }
        return root;
    }

    public int findIndex(int val, int iStart, int iEnd){
        for (int i = iStart; i <= iEnd; i++) {
            if (val == this.inorder[i]){
                return i;
            }
        }
        return 0;
    }




    public void preorderTraversal(TreeNode root){
        if (root == null){
            return;
        }
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        System.out.println(root.val);

    }

    public static void main(String[] args) {
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};

        buildTreeByPreAndIn b = new buildTreeByPreAndIn();
        TreeNode root = b.buildTreeByPreAndIn(pre, in);
        b.preorderTraversal(root);
    }
}