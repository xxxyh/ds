package jianzhioffer;

public class Solution21 {
    public int[] exchange(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while(i < j){
            while(i < nums.length && (nums[i] & 1) == 1){//奇数
                i++;
            }
            while(j >0 && (nums[j] & 1) == 0){//偶数
                j--;
            }
            if(i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(new Solution21().exchange(new int[]{1,3,5}));
    }
}
