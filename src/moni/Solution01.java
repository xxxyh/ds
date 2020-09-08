package moni;

public class Solution01 {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        int count = 0;
        for(int i = 0;i < strs[0].length();i++){
            boolean flag = false;
            char c = strs[0].charAt(i);
            for(int j = 1;j < strs.length;j++){
                if(strs[j].length() <= i || strs[j].charAt(i) != c){
                    flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }else{
                count++;
            }
        }
        return strs[0].substring(0, count);
    }

    public static void main(String[] args) {
        System.out.println(new Solution01().longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }
}
