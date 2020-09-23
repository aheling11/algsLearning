package Bishi.Alibaba.meituan;

import java.util.*;

public class Solution5 {


    static class Item implements Comparable<Item>{
        int id;
        int priority;
        int nes;

        public Item(int id, int priority, int nes) {
            this.id = id;
            this.priority = priority;
            this.nes = nes;
        }
        @Override
        public int compareTo(Item o) {
            if (this.nes > o.nes){
                return -1;
            } else if (this.nes < o.nes){
                return 1;
            } else {
                if (this.priority < o.priority){
                    return 1;
                } else if(this.priority > o.priority){
                    return -1;
                } else return 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Item> list = new ArrayList<>();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            Item item = new Item(i + 1, in.nextInt(), in.nextInt());
            list.add(item);
        }
        Collections.sort(list);
        for (Item item : list) {
            System.out.print(item.id + " ");
        }
    }


}
