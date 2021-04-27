package leetcode;

public class Solution1370 {
    public String sortString(String s) {
        if(s == null || s.length() < 2){
            return s;
        }
        int[] arr = new int[26];
        int len = s.length();
        for(int i = 0;i < len;i++){
            arr[s.charAt(i) - 'a']++;
        }
        char[] res = new char[len];
        int index = 0;
        while(index < len){
            for(int i = 0;i < 26;i++){
                if(arr[i] != 0){
                    arr[i]--;
                    res[index++] = (char)('a' + i);
                }
            }
            for(int i = 25;i >= 0;i--){
                if(arr[i] != 0){
                    arr[i]--;
                    res[index++] = (char)('a' + i);
                }
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        System.out.println(new Solution1370().sortString("rat"));
    }
}
