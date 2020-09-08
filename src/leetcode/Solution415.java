package leetcode;

public class Solution415 {
    public String addStrings(String num1, String num2) {
        int l = num1.length();
        int r = num2.length();
        int N = Math.min(l , r);
        StringBuilder sb = new StringBuilder();
        int index = 0;
        boolean flag = false;
        while(index < N){
            Integer left = Integer.valueOf(String.valueOf(num1.charAt(l - 1 - index)));
            Integer right = Integer.valueOf(String.valueOf(num2.charAt(r - 1 - index)));
            Integer num = left + right;
            if(flag){
                num++;
            }
            if(num > 9){
                num = num - 10;
                flag = true;
            }else{
                flag = false;
            }
            sb.append(num);
            index++;
        }
        if(index < l){
            for(int i = index;i < l;i++){
                Integer num = Integer.valueOf(String.valueOf(num1.charAt(l - 1 - i)));
                if(flag){
                    num++;
                }
                if(num > 9){
                    num = num - 10;
                    flag = true;
                }else{
                    flag = false;
                }
                sb.append(num);
            }
        }else{
            for(int i = index;i < r;i++){
                Integer num = Integer.valueOf(String.valueOf(num2.charAt(r - 1 - i)));
                if(flag){
                    num++;
                }
                if(num > 9){
                    num = num - 10;
                    flag = true;
                }else{
                    flag = false;
                }
                sb.append(num);
            }
        }
        if(flag){
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution415().addStrings("1", "9"));
    }
}
