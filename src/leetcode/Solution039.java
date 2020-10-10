package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution039 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, 0,0, target, new ArrayList<>());
        return result;
    }

    private void dfs(int[] candidates, int index, int current, int target, List<Integer> used){
        if(current > target){
            return;
        }
        if(current == target){
            result.add(new ArrayList<>(used));
            return;
        }
        used.add(candidates[index]);
        dfs(candidates, index,current + candidates[index], target, used);
        used.remove(used.size() - 1);
        for(int i = index + 1;i < candidates.length;i++){
            used.add(candidates[i]);
            dfs(candidates, i,current + candidates[i], target, used);
            used.remove(used.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution039().combinationSum(new int[]{2,3,5}, 8));
    }
}
