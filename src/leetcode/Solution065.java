package leetcode;

public class Solution065 {
    public boolean isNumber(String s) {
        int pointNumber = 0;
        int eNumber = 0;
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            if(c >= '0' && c <= '9'){
                continue;
            }else if(c == '-' || c == '+'){
                if((i == 0 || s.charAt(i - 1) == 'E' || s.charAt(i - 1) == 'e') && i != s.length() - 1){
                    continue;
                }else{
                    return false;
                }
            }else if(c == 'e' || c == 'E'){
                if(i == 0 || i == s.length() - 1){
                    return false;
                }
                char last = s.charAt(i - 1);
                if(!(last <= '9' && last >= '0' || last == '.')){
                    return false;
                }
                eNumber++;
                if(eNumber > 1){
                    return false;
                }
            }else if(c == '.'){
                if(eNumber > 0){
                    return false;
                }
                boolean flag = false;
                if(i != 0){
                    char last = s.charAt(i - 1);
                    if(last >= '0' && last <= '9'){
                        flag = flag || true;
                    }
                }
                if(i != s.length() - 1){
                    char last = s.charAt(i + 1);
                    if(last >= '0' && last <= '9'){
                        flag = flag || true;
                    }
                }
                if(!flag){
                    return false;
                }
                pointNumber++;
                if(pointNumber > 1){
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution065().isNumber(""));
    }
}
