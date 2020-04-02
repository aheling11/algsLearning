package leetcode;

import java.util.*;

class maxEvents {

    static class Number implements Comparable<Number>{
        Integer data;
        int index;
        public Number(Integer data, int index) {
            this.data = data;
            this.index = index;
        }
        @Override
        public int compareTo(Number number) {
            return data.compareTo(number.data);
        }
    }
    public static int maxEvents(int[][] events) {
        Number[] sorted = new Number[events.length];
        for (int i = 0; i < events.length; i++) {
            sorted[i] = new Number(events[i][1], i);
        }
        Arrays.sort(sorted);
        int[] occupiedDays = new int[10001];
        int sum = 0;
        for(Number number : sorted){
            int index = number.index;
            for (int i = events[index][0]; i <= events[index][1]; i++) {
                if (occupiedDays[i] == 0){
                    occupiedDays[i] = 1;
                    sum++;
                    break;
                }
            }
        }
        return sum;
    }
    public static int maxEvents2(int[][] events) {
        Arrays.sort(events, (o1 , o2) -> o1[1] - o2[1]);
        Set<Integer> set = new HashSet<>();
        for (int[] event : events) {
            int s = event[0];
            int e = event[1];
            for (int i = s; i < e; i++) {
                if (!set.contains(i)){
                    set.add(i);
                    break;
                }
            }
        }
        return set.size();
    }
//    public static int get

    public static void main(String[] args) {
//        int[][] events = {{1,2},{2,3},{3,4}};
        int[][] events = {{1,4},{4,4},{2,2},{3,4},{1,1}};
//        int[][] events = {{1,1},{1,2},{1,3},{1,4},{1,5},{2,2},{3,4},{1,1}};
        Arrays.sort(events, (o1, o2) -> o1[1] - o2[1]);
        for(int[] event : events){
            System.out.print(event[0]);
            System.out.print(" ");
            System.out.print(event[1]);
            System.out.println();
        }
        int result = maxEvents(events);
        System.out.println(result);

    }
}