package leetcode;

public class Solution1004 {
    public int longestOnes(int[] A, int K) {
        int res = 0;
        int left = 0, right = 0;
        int zeroNum = 0;
        while(right < A.length){
            if(A[right] == 0){
                zeroNum++;
            }
            while(zeroNum > K){
                if(A[left++] == 0){
                    zeroNum--;
                }
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1004().longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
    }
}
