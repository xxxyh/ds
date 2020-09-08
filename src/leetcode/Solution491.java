package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution491 {
    private List<Integer> temp = new ArrayList<>();
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(0, Integer.MIN_VALUE, nums);
        return result;
    }
    private void dfs(int current, int last, int[] nums){
        if(current == nums.length){
            if(temp.size() >= 2){
                result.add(new ArrayList<>(temp));
            }
            return;
        }
        if(nums[current] >= last){
            temp.add(nums[current]);
            dfs(current + 1, nums[current], nums);
            temp.remove(temp.size() - 1);
        }
        if(nums[current] != last){
            dfs(current + 1, last, nums);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution491().findSubsequences(new int[]{4, 6, 7, 7}));
    }
}
