package jianzhioffer;

public class Solution16 {
    public double myPow(double x, int n) {
        double d = 1.0;
        for(int i = n;i != 0;i /= 2){
            if(i % 2 != 0){
                d *= x;
            }
            x *= x;
        }
        return n < 0 ? 1.0d / d : d;
    }

    public static void main(String[] args) {
        System.out.println(new Solution16().myPow(2.0, 10));
    }
}
