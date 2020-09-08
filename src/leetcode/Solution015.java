package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution015 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 3){
            return result;
        }
        Arrays.sort(nums);
        int N = nums.length;
        for(int i = 0;i < nums.length - 2;i++){
            int l = i, r = nums.length - 1;
            while(l < r){
                if(nums[i] + nums[l] + nums[r] < 0){
                    l++;
                    while(l < r && nums[l] == nums[l+1]){
                        l++;
                    }
                }else if(nums[i] + nums[l] + nums[r] > 0){
                    r--;
                    while(l < r && nums[r] == nums[r - 1]){
                        r--;
                    }
                }else{
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    result.add(list);
                    l++;
                    r--;
                    while(l < r && nums[l] == nums[l+1]){
                        l++;
                    }
                    while(l < r && nums[r] == nums[r - 1]){
                        r--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution015().threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
