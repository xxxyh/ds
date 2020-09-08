package leetcode;


public class Solution459 {
    public boolean repeatedSubstringPattern(String s) {
        if(s == null){
            return false;
        }
        if(s.length() == 0){
            return true;
        }
        String t = s + s;
        return t.substring(1, t.length() - 1).indexOf(s) != -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution459().repeatedSubstringPattern("a"));
    }
}
