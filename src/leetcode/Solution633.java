package leetcode;

public class Solution633 {
    public boolean judgeSquareSum(int c) {
        double sqr = Math.sqrt(c);
        for(int i = 1;i < sqr;i++){
            for(int j = (int)sqr - i;j < sqr;j++){
                if(i - j > sqr ||  j - i > sqr){
                    break;
                }
                if(i * i + j * j == c){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution633().judgeSquareSum(4));
    }
}
