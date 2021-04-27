package leetcode;

public class Solution042 {
    public int trap(int[] height) {
        int n = height.length;
        int[] lmax = new int[n];
        int[] rmax = new int[n];
        for(int i = 1;i < n;i++){
            lmax[i] = Math.max(lmax[i - 1], height[i - 1]);
        }
        for(int i = n - 2;i >= 0;i--){
            rmax[i] = Math.max(rmax[i + 1], height[i + 1]);
        }
        int res = 0;
        for(int i = 0;i < n;i++){
            int min = Math.min(lmax[i], rmax[i])- height[i];
            if(min < 0){
                min = 0;
            }
            res +=  min;
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution042().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
}
