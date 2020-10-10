package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution047 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), new HashMap<>(), new HashSet<>());
        return res;
    }
    private void dfs(int[] nums, List<Integer> current, Map<Integer, List<Integer>> indexMap, Set<Integer> used){
        if(current.size() == nums.length){
            res.add(new ArrayList<>(current));
            return;
        }

        for(int i = 0;i < nums.length;i++){
            if(used.contains(i)){
                continue;
            }
            //例如[1,1,2]，只按照第一个1，第二个1的顺序来取，不能反着来
            if(indexMap.containsKey(nums[i])){
                List<Integer> list = indexMap.get(nums[i]);
                if(list.size() > 0 && list.get(list.size() - 1) > i){
                    continue;
                }
            }
            current.add(nums[i]);
            used.add(i);
            indexMap.computeIfAbsent(nums[i], k->new ArrayList<>());
            indexMap.get(nums[i]).add(i);
            dfs(nums, current, indexMap, used);
            current.remove(current.size() - 1);
            used.remove(i);
            List<Integer> list = indexMap.get(nums[i]);
            list.remove(list.size() - 1);
        }
    }
}
