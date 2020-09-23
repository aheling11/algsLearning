package Bishi.Alibaba.网易0911;

import java.util.*;

public class First2 {

    static String res = "";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String a = in.nextLine();
        String b = in.nextLine();
        char[] barr = b.toCharArray();
        Arrays.sort(barr);

        Deque<Character> path = new LinkedList<>();
        int[] visited = new int[n];
        if (res.equals("")){
            System.out.println("-1");
        } else System.out.println(res);
    }

    public static void dfs(Deque<Character> path, char[] arr, String target, int resLen, int[] visited){

    }

    public static boolean compare(String path, String target){
        return path.compareTo(target) > 0;
    }
}
