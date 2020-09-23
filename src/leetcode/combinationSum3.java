package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class combinationSum3 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        Deque<Integer> path = new LinkedList<>();
        dfs(path, 1, n, k);
        return res;
    }

    public void dfs(Deque<Integer> path, int start, int n, int k){

        if(path.size() == k && n == 0){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (n < 0){
                break;
            }
            path.addLast(i);
            dfs(path, i + 1, n - i, k);
            path.removeLast();
        }
    }


}