package ToOffer;

import utils.TreeNode;

import java.util.*;

class levelOrder {
    public int[] levelOrder1(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            list.add(cur.val);
            if (cur.left != null) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int count = queue.size();
            while (count > 0){
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null)  queue.add(cur.left);
                if (cur.right != null)  queue.add(cur.right);
                count--;
            }
            if (!list.isEmpty()) res.add(list);
        }
        return res;
    }

    public List<List<Integer>> levelOrder3(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int odd = 1;
        while (!queue.isEmpty()){
            //奇数,左到右打印
            List<Integer> list = new ArrayList<>();
            int count = queue.size();
            while (count > 0){
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null)  queue.add(cur.left);
                if (cur.right != null)  queue.add(cur.right);
                count--;
            }
            if (!list.isEmpty()){
                if ((odd & 1) == 1) res.add(list);
                else {
                    Collections.reverse(list);
                    res.add(list);
                }
            }
            odd++;

        }
        return res;
    }
}