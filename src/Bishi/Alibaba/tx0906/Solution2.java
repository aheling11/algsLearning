package Bishi.Alibaba.tx0906;

import java.util.*;

public class Solution2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        TreeMap<String, Integer> map = new TreeMap<>();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String key = in.nextLine();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, ((o1, o2) -> o2.getValue().compareTo(o1.getValue())));

        for (int i = 0; i < k; i++) {
            Map.Entry<String, Integer> entry = list.get(i);
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        Collections.sort(list, (Comparator.comparing(Map.Entry::getValue)));

        for (int i = 0; i < k; i++) {
            Map.Entry<String, Integer> entry = list.get(i);
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}
