package leetcode;

public class Solution1672 {
    public int maximumWealth(int[][] accounts) {
        int len = accounts.length;
        int max = 0;
        for(int i = 0;i < len;i++){
            int sum = 0;
            for(int a : accounts[i]){
                sum += a;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
