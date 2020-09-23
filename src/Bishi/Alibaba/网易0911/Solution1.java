package Bishi.Alibaba.网易0911;


import java.util.*;

public class Solution1 {

    static class TreeNode{
        int val;
        int left;
        int right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        HashMap<Integer, TreeNode> hasChild = new HashMap<>();
        HashSet<Integer> childSet = new HashSet<>();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String t = in.nextLine();
            String[] strings = t.split(" ");
            int id = Integer.parseInt(strings[0]);
            String type = strings[1];
            int nextId = Integer.parseInt(strings[2]);
            TreeNode newNode = hasChild.getOrDefault(id, new TreeNode(id));
            if (type.equals("left")){
                newNode.left = nextId;
            } else {
                newNode.right = nextId;
            }
            childSet.add(nextId);
            hasChild.put(id, newNode);
        }

        Set<Integer> fathers = hasChild.keySet();
        childSet.removeAll(fathers);
        int cnt = 0;
        for (Integer integer : fathers) {
            TreeNode treeNode = hasChild.get(integer);
            if (childSet.contains(treeNode.left) && childSet.contains(treeNode.right)){
                cnt++;
            }
        }
        System.out.println(cnt);


    }


}
