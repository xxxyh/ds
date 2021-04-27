package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution1018 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        int num = 0;
        for(int i = 0;i < A.length;i++){
            num = num << 1;
            num += A[i];
            num %= 10;
            res.add(num % 5 == 0);
        }
        return res;
    }
}
