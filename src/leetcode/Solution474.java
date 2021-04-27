package leetcode;

public class Solution474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];//m个0，n个1
        dp[0][0] = 0;
        for(int p = 0;p < strs.length;p++){
            String str = strs[p];
            int[] nums = numOfStr(str);
            boolean flag = false;
            for(int i = m;i >= nums[0];i--){
                for(int j = n;j >= nums[1];j--){
                    dp[i][j] = Math.max(dp[i][j], dp[i - nums[0]][j - nums[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private int[] numOfStr(String str){
        int numOfZero = 0;
        int numOfOne = 0;
        int[] res = new int[2];
        for(int i = 0;i < str.length();i++){
            char c = str.charAt(i);
            if(c == '0'){
                numOfZero++;
            }else if(c == '1'){
                numOfOne++;
            }
        }
        res[0] = numOfZero;
        res[1] = numOfOne;
        return res;
    }

    public static void main(String[] args) {
        new Solution474().findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3);
    }
}
