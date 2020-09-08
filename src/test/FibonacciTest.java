package test;

public class FibonacciTest {

    public static int fibonacci(int n){
        if(n < 1){
            return 0;
        }
        int[] dp = new int[n];
        return execute(n, dp);
    }
    private static int execute(int n, int[] dp){
        if(n == 0 || n == 1){
            return n;
        }
        if(dp[n - 1] != 0){
            return dp[n - 1];
        }
        return dp[n - 1] = execute(n - 1, dp) + execute(n - 2, dp);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(-1));
    }
}
