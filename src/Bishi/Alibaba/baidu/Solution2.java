package Bishi.Alibaba.baidu;

import java.util.*;

public class Solution2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        HashMap<Integer, Queue> map = new HashMap<>();
        List<Queue> queues = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Queue<Integer> block = new LinkedList<>();
            block.add(i);
            map.put(i, block);
            queues.add(block);
        }
        in.nextLine();
        for (int i = 0; i < m; i++) {
            String s = in.nextLine();
            String[] s1 = s.split(" ");
            int a = Integer.parseInt(s1[1]) - 1;
            int b = Integer.parseInt(s1[2]) - 1;
            if (s1[0].equals("C")) Cmethod(map, a, b, queues);
            else if (s1[0].equals("Q")) {
                int qmethod = Qmethod(map, a, b, queues);
                System.out.println(qmethod);
            }
        }
    }


    private static int Qmethod(HashMap<Integer, Queue> map, int a, int b, List<Queue> blocks) {
        if (map.get(a) == map.get(b)){
            Queue<Integer> queue = map.get(a);
            ArrayList<Integer> list = new ArrayList<>(queue);
            int abs = Math.abs(list.indexOf(a) - list.indexOf(b)) - 1;
            return abs;
        }
        return -1;

    }

    private static void Cmethod(HashMap<Integer, Queue> map, int a, int b, List<Queue> blocks) {
        if (a == b){
            return;
        }
        Queue<Integer> aBlock = blocks.get(a);
        Queue<Integer> block = blocks.get(b);
        while (!aBlock.isEmpty()){
            Integer player = aBlock.poll();
            map.put(player, block);
            block.add(player);
        }
    }


}
