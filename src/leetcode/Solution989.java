package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new ArrayList<>();
        List<Integer> k = new ArrayList<>();
        while(K > 0){
            k.add(K % 10);
            K = K / 10;
        }
        int max = Math.max(A.length, k.size());
        int carry = 0;
        for(int i = 0;i < max;i++){
            int p;
            if(i >= A.length){
                p = 0;
            }else{
                p = A[A.length - i - 1];
            }
            int q;
            if(i >= k.size()){
                q = 0;
            }else{
                q = k.get(i);
            }
            int sum = p + q + carry;
            if(sum >= 10){
                carry = 1;
                sum = sum - 10;
            }else{
                carry = 0;
            }
            res.add(sum);
        }
        if(carry == 1){
            res.add(1);
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution989().addToArrayForm(new int[]{9,9,9,9,9,9,9,9,9,9}, 1));
    }
}
