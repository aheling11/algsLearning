package utils;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x){
        val = x;
    }


    public static void preTravarsal(TreeNode root){
        if (root == null){
            System.out.print(" null");
            return;
        }
        System.out.print(" " + root.val);
        preTravarsal(root.left);
        preTravarsal(root.right);
    }


}
