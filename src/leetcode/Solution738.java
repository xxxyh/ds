package leetcode;

public class Solution738 {
    public int monotoneIncreasingDigits(int N) {
        String s = String.valueOf(N);
        char[] chars = s.toCharArray();
        int flag = s.length();
        for(int i = s.length() - 1;i > 0;i--){
            if(chars[i] < chars[i - 1]){
                chars[i - 1]--;
                flag = i;
            }
        }
        for(int i = flag;i < s.length();i++){
            chars[i] = '9';
        }
        return Integer.valueOf(new String(chars));
    }

    public static void main(String[] args) {
        System.out.println(new Solution738().monotoneIncreasingDigits(172));
    }
}
