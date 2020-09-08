package leetcode;

public class Solution014 {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        int max = strs[0].length();
        for(String str : strs){
            if(str.length() < max){
                max = str.length();
            }
        }
        int length = 0;
        int i = 0;
        for(; i < max;i++){
            boolean isbreak = false;
            char c = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++){
                if(strs[j].charAt(i) != c){
                    isbreak = true;
                }
            }
            if(isbreak == true){
                break;
            }
        }
        if(i > 0){
            return strs[0].substring(0, i);
        }else{
            return "";
        }
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"dag","dacecar","dar"};
        System.out.println(longestCommonPrefix(strs));
    }
}
