package Bishi.Alibaba.tx0906;

import java.util.*;

public class Solution4 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> list = new ArrayList<>();
        List<Integer> keys = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int t = in.nextInt();
            list.add(t);
            keys.add(t);
        }
        Collections.sort(list);
        int mid = list.size() / 2;
        for (Integer key : keys) {
            int index = list.indexOf(key);
            if (index >= mid) System.out.println(list.get(mid - 1));
            else System.out.println(list.get(mid));
        }


    }
}
