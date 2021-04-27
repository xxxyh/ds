package zhousai;

public class Solution5697 {
    public boolean checkOnesSegment(String s) {
        int i = 0;
        for(;i < s.length();i++){
            if(s.charAt(i) == '0'){
                break;
            }
        }
        for(;i < s.length();i++){
            if(s.charAt(i) == '1'){
               return false;
            }
        }
        return true;
    }
}
