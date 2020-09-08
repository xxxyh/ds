package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution046 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0){
            return result;
        }
        permute(nums, new LinkedList<>(), new HashSet<>());
        return result;
    }
    private void permute(int[] nums, LinkedList<Integer> currentList, Set<Integer> used){
        if(currentList.size() == nums.length){
            result.add(new ArrayList<>(currentList));
            return;
        }
        for(int i = 0;i < nums.length;i++){
            if(used.contains(nums[i])){
                continue;
            }
            currentList.add(nums[i]);
            used.add(nums[i]);
            permute(nums, currentList, used);
            currentList.removeLast();
            used.remove(nums[i]);
        }
    }
}
