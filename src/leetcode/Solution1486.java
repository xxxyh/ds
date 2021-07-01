package leetcode;

public class Solution1486 {
    public int xorOperation(int n, int start) {
        if(n == 0){
            return 0;
        }
        int res = start;
        for(int i = 1;i < n;i++){
            res ^= 2 * i + start;
        }
        return res;
    }
}
