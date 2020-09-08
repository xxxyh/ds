package leetcode;

public class Solution560 {

    public static int subarraySum(int[] nums, int k) {
        int N = nums.length;

        int[] presum = new int[N + 1];//[0,N)的前缀和
        int sum = 0;
        for(int i = 0;i < N;i++){//[0,N - 1)的前缀和
            presum[i] = sum;
            sum += nums[i];
        }
        presum[N] = sum;

        int count = 0;
        for(int i = 0;i <= N;i++){
            for(int j = i + 1;j <= N;j++){
                if(presum[j] - presum[i] == k){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2};
        int k = 2;
        System.out.println(subarraySum(nums, k));
    }
}
