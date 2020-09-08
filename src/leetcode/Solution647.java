package leetcode;

public class Solution647 {
    int count = 0;
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        for(int i = 0;i < s.length();i++){
            count(s, i, i);//奇数
            count(s, i ,i + 1);//偶数
        }
        return count;
    }

    public void count(String s, int start, int end){
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            count++;
            start--;
            end++;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution647().countSubstrings("aaa"));
    }
}
