package leetcode;

public class Solution1049 {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for(int stone : stones){
            sum += stone;
        }

        int w = sum / 2;
        int[] dp = new int[w + 1];
        for(int i = 0;i < n;i++){
            for(int j = w;j >= stones[i];j--){
                dp[j] = Math.max(dp[j],dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - 2 * dp[w];
    }

    public static void main(String[] args) {
        System.out.println(new Solution1049().lastStoneWeightII(new int[]{1,2}));
    }
}
