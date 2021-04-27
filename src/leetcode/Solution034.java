package leetcode;

public class Solution034 {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1, -1};
        }
        int[] res = new int[2];
        int left = 0;
        int right = nums.length;
        while(left < right){//求左边界
            int mid = (right - left) / 2 + left;
            if(nums[mid] == target){
                right = mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid;
            }
        }
        if(left == nums.length || nums[left] != target){
            res[0] = -1;
            res[1] = -1;
            return res;
        }else{
            res[0] = left;
        }

        right = nums.length;
        while(left < right){
            int mid = (right - left) / 2 + left;
            if(nums[mid] == target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }
        }
        if(left == 0 || nums[left - 1] != target){
            res[0] = -1;
            res[1] = -1;
            return res;
        }else{
            res[1] = left - 1;
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution034().searchRange(new int[]{2,2}, 3);
    }
}
