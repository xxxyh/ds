package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution763 {
    public List<Integer> partitionLabels(String S) {
        int[] arr = new int[26];
        for(int index = 0;index < S.length();index++){
            arr[S.charAt(index) - 'a'] = index;
        }
        List<Integer> res = new ArrayList<>();
        int i = 0;
        int j = S.length() - 1;
        while(i <= j){
            j = arr[S.charAt(i) - 'a'];
            for(int k = i + 1;k < j;k++){
                j = Math.max(j, arr[S.charAt(k) - 'a']);
            }
            res.add(j - i + 1);
            i = j + 1;
            j = S.length() - 1;
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution763().partitionLabels("ababcbacadefegdehijhklij");
    }
}
