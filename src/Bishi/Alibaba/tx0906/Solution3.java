package Bishi.Alibaba.tx0906;

import java.util.*;

public class Solution3 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        List<Set<Integer>> list = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int k = in.nextInt();
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < k; j++) {
                int temp = in.nextInt();
                List<Integer> tempList = map.getOrDefault(temp, new ArrayList<>());
                tempList.add(i);
                map.put(temp, tempList);
                set.add(temp);
            }
            list.add(set);
        }

        int ans = 0;
        List<Integer> list0 = map.get(0);
        Set<Integer> resSet = new HashSet<>();
        for (Integer index : list0) {
            Set<Integer> integers = list.get(index);
            resSet.addAll(integers);
        }

        for (Integer item : resSet) {

        }

        System.out.println(ans);


    }
}
