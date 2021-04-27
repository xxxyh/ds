package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        int sumB = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i < A.length;i++){
            sumA += A[i];
            set.add(A[i]);
        }
        for(int i = 0;i < B.length;i++){
            sumB += B[i];
        }

        int dif = (sumA - sumB) / 2;
        for(int i = 0;i < B.length;i++){
            if(set.contains(dif + B[i])){
                return new int[]{dif + B[i], B[i]};
            }
        }
        return null;
    }
}
