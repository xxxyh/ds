package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution078 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int index, List<Integer> used){
        if(index == nums.length){
            res.add(new ArrayList<>(used));
            return;
        }

        used.add(nums[index]);
        dfs(nums, index + 1, used);
        used.remove(used.size() - 1);

        dfs(nums, index + 1, used);
    }

    public static void main(String[] args) {
        System.out.println(new Solution078().subsets(new int[]{1,2,3}));
    }
}
