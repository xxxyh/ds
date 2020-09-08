package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }
        for(int i = 0;i < nums.length;i++){
            int num = Math.abs(nums[i]);
            if(nums[num - 1] > 0){
                nums[num - 1] *= -1;
            }else{
                result.add(num);
            }
        }
        return result;
    }
}
