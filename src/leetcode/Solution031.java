package leetcode;

import java.util.Arrays;

public class Solution031 {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length < 2){
            return;
        }

        for(int i = nums.length - 1;i > 0;i--){
            if(nums[i - 1] < nums[i]){
                int k = i;
                while(k < nums.length && nums[k] > nums[i - 1]){
                    k++;
                }
                k--;
                swap(nums, k, i - 1);
                Arrays.sort(nums, i, nums.length);
                return;
            }
        }
        //如果走到这里，说明不存在下一个更大的序列
        int i = 0;
        int j = nums.length - 1;
        while(i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 5};
        new Solution031().nextPermutation(arr);
        for(int num : arr){
            System.out.println(num);
        }
    }
}
