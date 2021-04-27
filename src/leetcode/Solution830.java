package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution830 {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        if(s.length() == 0){
            return res;
        }
        char c = '-';
        int index = 0;
        while(index < s.length()){
            int start = index;
            while(index < s.length() && s.charAt(index) == c){
                index++;
            }
            if(index < s.length()){
                c = s.charAt(index);
            }
            int end = index;
            if(end - start >= 3){
                res.add(Arrays.asList(start, end - 1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution830().largeGroupPositions("aaa");
    }
}
