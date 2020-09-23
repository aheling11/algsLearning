package Bishi.Alibaba.网易0911;

import java.util.HashMap;
import java.util.Scanner;

public class Solution1_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        HashMap<Integer, Solution1.TreeNode> map = new HashMap<>();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String t = in.nextLine();
            String[] strings = t.split(" ");
            int id = Integer.parseInt(strings[0]);
            String type = strings[1];
            int nextId = Integer.parseInt(strings[2]);

        }

    }
}
