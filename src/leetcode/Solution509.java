package leetcode;

public class Solution509 {
    public int fib(int n) {
        if(n < 2){
            return n;
        }
        int dp0 = 0;
        int dp1 = 1;
        for(int i = 1;i < n;i++){
            int tmp = dp0 + dp1;
            dp0 = dp1;
            dp1 = tmp;
        }
        return dp1;
    }
}
