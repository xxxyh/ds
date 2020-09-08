package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution017to2 {
    String[] strs = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return result;
        }
        letterCombinations(digits, 0, new StringBuilder());
        return result;
    }
    private void letterCombinations(String digits, int index, StringBuilder sb){
        if(index == digits.length()){
            result.add(sb.toString());
            return;
        }
        Integer current = Integer.valueOf(digits.substring(index, index + 1));
        String currentStr = strs[current - 2];
        for(int i = 0;i < currentStr.length();i++){
            sb.append(currentStr.charAt(i));
            letterCombinations(digits, index + 1, sb);
            sb.deleteCharAt(index);
        }
    }
    public static void main(String[] args) {
        System.out.println(new Solution017to2().letterCombinations("23"));
    }
}
