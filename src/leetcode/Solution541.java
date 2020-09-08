package leetcode;

public class Solution541 {
    public String reverseStr(String s, int k) {
        if(s == null || s.length() <= 1){
            return s;
        }
        char[] chars = new char[s.length()];
        int dk = 2 * k;
        for(int i = 0;i < s.length();i++){
            if(i % dk == 0){
                if(i + k < s.length()){
                    for(int j = 0;j < k;j++){
                        chars[i + j] = s.charAt(i + k - j - 1);
                    }
                }else{
                    int max = s.length() - i;
                    for(int j = 0;j < max;j++){
                        chars[i + j] = s.charAt(i + max - j - 1);
                    }
                }
                i += k - 1;
            }else{
                chars[i] = s.charAt(i);
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(new Solution541().reverseStr("abcdefg", 2));
    }
}
