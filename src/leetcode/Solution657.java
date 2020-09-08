package leetcode;

public class Solution657 {
    public boolean judgeCircle(String moves) {
        if(moves == null || moves.length() == 0){
            return true;
        }
        int ups = 0, downs = 0, lefts = 0, rights = 0;
        for(int i = 0;i < moves.length();i++){
            int c = moves.charAt(i);
            if(c == 'U'){
                ups++;
            }
            if(c == 'D'){
                downs++;
            }
            if(c == 'L'){
                lefts++;
            }
            if(c == 'R'){
                rights++;
            }
        }
        return ups == downs && rights == lefts;
    }
}
