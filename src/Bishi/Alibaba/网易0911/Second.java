package Bishi.Alibaba.网易0911;

import java.util.*;

public class Second {

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
        dfs(path, barr, a, n, visited);
        if (res.equals("")){
            System.out.println("-1");
        } else System.out.println(res);
    }

    public static void dfs(Deque<Character> path, char[] arr, String target, int resLen, int[] visited){
        if (path.size() == resLen){
            StringBuilder sb = new StringBuilder();
            ArrayList<Character> list = new ArrayList<>(path);
            for (int i = 0; i < path.size(); i++) {
                sb.append(list.get(i));
            }
            if (compare(sb.toString(), target)){
                res = sb.toString();
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if(compare(res,target)){
                break;
            }
            if (i > 0 && arr[i] == arr[i - 1] && visited[i - 1] == 0){
                continue;
            }
            if (visited[i] == 1){
                continue;
            }
            path.addLast(arr[i]);
            visited[i] = 1;
            dfs(path, arr, target, resLen, visited);
            visited[i] = 0;
            path.removeLast();
        }
    }

    public static boolean compare(String path, String target){
        return path.compareTo(target) > 0;
    }


}
