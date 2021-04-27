package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution1002 {
    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        if(A == null || A.length == 0){
            return res;
        }
        int[][] arr = new int[A.length][26];
        for(int i = 0;i < A.length;i++){
            String a = A[i];
            for(char c : a.toCharArray()){
                arr[i][c - 'a']++;
            }
        }
        for(int j = 0;j < 26;j++){
            int min = arr[0][j];
            for(int i = 1;i < arr.length;i++){
                min = Math.min(arr[i][j], min);
            }
            for(int k = 0;k < min;k++){
                res.add("" + (char)('a' + j));
            }
        }
        return res;
    }
}
