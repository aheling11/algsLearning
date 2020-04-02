package ToOffer;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSymmetric(root.left, root.right);
    }
    public boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        if(root1.val != root2.val){
            return false;
        }
        return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
    }

    public boolean isSysmmetric_nonrecur(TreeNode root){
        if(root == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode cur1 = queue.poll();
            TreeNode cur2 = queue.poll();
            if(cur1 == null && cur2 == null){
                continue;
            }
            if (cur1 == null || cur2 == null){
                return false;
            }
            if (cur1.val != cur2.val){
                return false;
            }
            queue.add(cur1.left);
            queue.add(cur2.right);
            queue.add(cur1.right);
            queue.add(cur2.left);
        }
        return true;
    }

    public static void main(String[] args) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(null);
        TreeNode a = queue.poll();

    }
}