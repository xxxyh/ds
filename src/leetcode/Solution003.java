package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution003 {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        if(s == null || s.length() == 0){
            return max;
        }
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0;
        while(i <= j && j < s.length()){
            char c = s.charAt(j);
            if(!set.contains(c)){
                set.add(c);
                if(j - i >= max){
                    max = j - i + 1;
                }
            }else{
                while(s.charAt(i) != c && i < j){
                    set.remove(s.charAt(i));
                    i++;
                }
                i++;
            }
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution003().lengthOfLongestSubstring("pwwkew"));
    }
}
