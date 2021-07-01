package jianzhioffer;

public class Solution05 {
    public String replaceSpace(String s) {
        int spaceLen = 0;
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == ' '){
                spaceLen++;
            }
        }
        int index = 0;
        char[] chars = new char[s.length() + 2 * spaceLen];
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == ' '){
                chars[index++] = '%';
                chars[index++] = '2';
                chars[index++] = '0';
            }else{
                chars[index++] = s.charAt(i);
            }
        }
        return new String(chars);
    }
}
