package leetcode;

import java.util.Arrays;

public class Solution976 {
    public int largestPerimeter(int[] A) {
        if(A == null || A.length < 3){
            return 0;
        }

        Arrays.sort(A);

        for(int i = A.length - 1;i >= 2;i--){
            int j = i - 1;
            int k = i - 2;
            if(A[k] > A[i] - A[j]){
                return A[k] + A[i] + A[j];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution976().largestPerimeter(new int[]{3,2,3,4}));
    }
}
