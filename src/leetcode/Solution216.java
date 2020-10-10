package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution216 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(1, k, n, new ArrayList<>());
        return res;
    }
    private void dfs(int index, int k, int target, List<Integer> used){
        if(used.size() == k && target == 0){
            res.add(new ArrayList<>(used));
            return;
        }
        if(used.size() == k || target <= 0){
            return;
        }
        for(int i = index;i <= 9;i++){
            used.add(i);
            dfs(i + 1, k, target - i, used);
            used.remove(used.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution216().combinationSum3(3, 9));
    }
}
