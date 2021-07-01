package jianzhioffer;

public class Solution10to2 {
    public int numWays(int n) {
        if(n == 0){
            return 1;
        }
        int dp1 = 1;
        int dp2 = 2;
        for(int i = 1;i < n;i++){
            int sum = (dp1 + dp2) % 1000000007;
            dp1 = dp2;
            dp2 = sum;
        }
        return dp1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution10to2().numWays(2));
    }
}
