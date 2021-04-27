package leetcode;

import java.util.Arrays;

public class Solution1356 {
    public int[] sortByBits(int[] arr) {
        Integer[] nums = new Integer[arr.length];
        for(int i = 0;i < arr.length;i++){
            nums[i] = arr[i];
        }

        Arrays.sort(nums, (o1, o2)->{
            if(o1 == o2){
                return 0;
            }
            int count1 = Integer.bitCount(o1);
            int count2 = Integer.bitCount(o2);
            return count1 == count2 ? o1.compareTo(o2) : count1 - count2;
        });
        return Arrays.stream(nums).mapToInt(Integer::intValue).toArray();
    }
}
