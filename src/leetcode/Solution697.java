package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution697 {
    public int findShortestSubArray(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        Map<Integer, Integer> freMap = new HashMap<>();
        for(int num : nums){
            freMap.put(num, freMap.getOrDefault(num, 0) + 1);
        }
        int max = 0;
        for(int num : freMap.values()){
            max = Math.max(max, num);
        }
        Set<Integer> maxSet = new HashSet<>();
        for(Map.Entry<Integer, Integer> entry : freMap.entrySet()){
            if(entry.getValue() == max){
                maxSet.add(entry.getKey());
            }
        }
        Map<Integer, Integer> start = new HashMap<>();
        Map<Integer, Integer> end = new HashMap<>();
        for(int i = 0;i < n;i++){
            int num = nums[i];
            if(maxSet.contains(num) && !start.containsKey(num)){
                start.put(num, i);
            }
            if(start.size() == maxSet.size()){
                break;
            }
        }

        for(int i = n - 1;i >= 0;i--){
            int num = nums[i];
            if(maxSet.contains(num) && !end.containsKey(num)){
                end.put(num, i);
            }
            if(end.size() == maxSet.size()){
                break;
            }
        }
        int res = Integer.MAX_VALUE;
        for(int num : maxSet){
            int cur = end.get(num) - start.get(num) + 1;
            if(cur > 0){
                res = Math.min(cur, res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution697().findShortestSubArray(new int[]{1,2,2,3,1,4,2}));
    }
}
