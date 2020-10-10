package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution040 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new ArrayList<>());
        return res;
    }

    private void dfs(int[] candidates,int index, int target, List<Integer> used){
        if(target == 0){
            res.add(new ArrayList<>(used));
        }
        if(target < 0 || index == candidates.length){
            return;
        }

        for(int i = index;i < candidates.length;i++){
            if(i > index && candidates[i] == candidates[i - 1]){
                continue;
            }
            used.add(candidates[i]);
            dfs(candidates, i + 1, target - candidates[i], used);
            used.remove(used.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution040().combinationSum2(new int[]{2,5,2,1,2}, 5));
    }
}
