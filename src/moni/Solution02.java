package moni;

import java.util.ArrayList;
import java.util.List;

public class Solution02 {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> result = new ArrayList<>();
        if(S == null || S.length() < 3){
            return result;
        }
        int start = 0;
        int end = 0;
        boolean flag = false;
        while(end < S.length()){
            if(S.charAt(end) == S.charAt(start)){
                end++;
                flag = true;
            }else{
                flag = false;
                if(end - start >= 3){
                    List<Integer> current = new ArrayList<>();
                    current.add(start);
                    current.add(end - 1);
                    result.add(current);
                }
                start = end;
            }
        }
        if(flag && end - start >= 3){
            List<Integer> current = new ArrayList<>();
            current.add(start);
            current.add(end - 1);
            result.add(current);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution02().largeGroupPositions("abbxxxxzzy"));
    }
}
