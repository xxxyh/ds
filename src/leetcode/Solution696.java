package leetcode;

public class Solution696 {
    public int countBinarySubstrings(String s) {
        if(s == null || s.length() == 0);
        int sum = 0;
        char last = s.charAt(0);
        int lastNum = 0;
        int current = 0;
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == last){//还没变
                current++;
            }else{
                sum += Math.min(lastNum, current);
                lastNum = current;
                current = 1;
                last = s.charAt(i);
            }
        }
        sum += Math.min(lastNum, current);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution696().countBinarySubstrings("10101"));
    }
}
