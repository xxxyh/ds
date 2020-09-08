package leetcode;

public class Solution680 {
    public static boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        char[] chars = s.toCharArray();
        int count = 0;
        while(start < end){
            if(chars[start] == chars[end]){
                start++;
                end--;
            }else if(chars[start + 1] == chars[end] && (start + 2 >= end - 1 || chars[start + 2] == chars[end - 1])){
                start +=2;
                end --;
                count++;
            }else if(chars[start] == chars[end - 1] && (start + 1 >= end - 2 || chars[start + 1] == chars[end - 2])){
                start++;
                end -= 2;
                count++;
            }else{
                return false;
            }
            if(count > 1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
