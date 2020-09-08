package leetcode;

public class Solution005 {
    public String longestPalindrome(String s) {
        if(s == null || s.length() <= 1){
            return s;
        }
        int left = 0;
        int max = 0;
        char[] chars = s.toCharArray();
        for(int i = 0;i < chars.length;i++){
            int p = length(chars, i, i);//奇数长度的回文串
            int q = length(chars, i, i + 1);//偶数长度的回文串
            if(p > q && p > max){
                left = i - (p - 1) / 2;
                max = p;
            }else if(q > p && q > max){
                left = i - (q - 2) / 2;
                max = q;
            }
        }
        return s.substring(left, left + max);
    }
    private int length(char[] chars, int start, int end){
        while(start >= 0 && end < chars.length && chars[start] == chars[end]){
            start--;
            end++;
        }
        return end - start - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution005().longestPalindrome("cbbd"));
    }
}
