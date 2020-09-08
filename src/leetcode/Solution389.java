package leetcode;

public class Solution389 {
    public char findTheDifference(String s, String t) {
        int c1 = 0;
        for(int i = 0;i < s.length();i++){
            c1 += s.charAt(i) - 'a';
        }
        int c2 = 0;
        for(int i = 0;i < t.length();i++){
            c2 += t.charAt(i) - 'a';
        }
        return (char)('a' + (c2 - c1));
    }

    public static void main(String[] args) {
        System.out.println(new Solution389().findTheDifference("abcd", "abcde"));
    }
}
