package ToOffer;

import utils.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
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
public class Codec {

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (cur != null){
                queue.add(cur.left);
                queue.add(cur.right);
                result.append(cur.val).append(",");
            } else {
                result.append("n,");
            }
        }
        result.deleteCharAt(result.length() - 1);
//        result.append("]");
        return result.toString();
    }

    public static String serialize_1(TreeNode root) {
        if (root == null) return null;
        StringBuilder sb = new StringBuilder();
        help(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void help(TreeNode root, StringBuilder sb){
        if (root == null) {
            sb.append("n,");
            return;
        }
        sb.append(root.val).append(",");
        help(root.left, sb);
        help(root.right, sb);
    }



    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null) return null;
        String[] strings = data.split(",");
        if (strings.length < 1) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        if (strings[0].equals("n")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < strings.length){
            TreeNode cur = queue.poll();
            if (!strings[i].equals("n")) {
                cur.left = new TreeNode(Integer.parseInt(strings[i]));
                queue.add(cur.left);
            }
            if (!strings[i+1].equals("n")){
                cur.right = new TreeNode(Integer.parseInt(strings[i+1]));
                queue.add(cur.right);
            }
            i += 2;
        }
        return root;
    }

    public static TreeNode deserialize_1(String data) {
        String[] strings = data.split(",");
        if (strings.length < 1) return null;
        Queue<String> queue = new LinkedList<>(Arrays.asList(strings));
        queue.add(strings[0]);
        return deseriablizeProcess(queue);
    }

    public static TreeNode deseriablizeProcess(Queue<String> queue){
        String cur = queue.poll();
        if (cur.equals("n")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(cur));
        root.left = deseriablizeProcess(queue);
        root.right = deseriablizeProcess(queue);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        root = null;



        String serialize = serialize_1(root);
        System.out.println(serialize);

        TreeNode deserialize = deserialize_1(serialize);
        TreeNode.preTravarsal(deserialize);


    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));