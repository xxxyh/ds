package leetcode;

public class Solution925 {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        while(i < name.length()){
            if(j >= typed.length()){
                return false;
            }
            char c1 = name.charAt(i);
            char c2 = typed.charAt(j);
            if(c1 == c2){
                i++;
                j++;
            }else{
                if(j - 1 >= 0 && typed.charAt(j - 1) == c2){
                    j++;
                }else{
                    return false;
                }
            }
        }
        while(j < typed.length()){
            if(typed.charAt(j - 1) != typed.charAt(j)){
                return false;
            }
            j++;
        }
        return true;
    }
}
