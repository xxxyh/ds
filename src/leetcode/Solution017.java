package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution017 {
    String[] strs = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return result;
        }
        letterCombinations(digits, 0, "");
        return result;
    }
    private void letterCombinations(String digits, int current, String prev){
        if(current == digits.length()){
            result.add(prev);
            return;
        }
        Integer index = Integer.valueOf(digits.substring(current, current + 1));
        String currentStr = strs[index - 2];
        for(int i = 0;i < currentStr.length();i++){
            letterCombinations(digits, current + 1, prev + currentStr.charAt(i));
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution017().letterCombinations("23"));
    }
}
