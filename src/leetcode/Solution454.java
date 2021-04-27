package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < A.length;i++){
            for(int j = 0;j < B.length;j++){
                int cur = -1 *(A[i] + B[j]);
                map.put(cur, map.getOrDefault(cur, 0) + 1);
            }
        }
        int res = 0;
        for(int i = 0;i < C.length;i++){
            for(int j = 0;j < D.length;j++){
               int cur = C[i] + D[j];
               if(map.containsKey(cur)){
                   res += map.get(cur);
               }
            }
        }
        return res;
    }
}
