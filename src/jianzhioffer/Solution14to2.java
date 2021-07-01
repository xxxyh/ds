package jianzhioffer;

public class Solution14to2 {
    public int cuttingRope(int n) {
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }
        long res = 1;
        while(n > 4){
            n -= 3;
            res *= 3;
            res %= 1000000007;
        }
        return (int)((res * n) % 1000000007);
    }

    public static void main(String[] args) {
        System.out.println(new Solution14to2().cuttingRope(127));
    }
}
