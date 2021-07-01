package jianzhioffer;

public class Solution17 {
    public int[] printNumbers(int n) {
        int res = 9;
        int k = 1;
        for(int i = 1;i < n;i++){
            k *= 10;
            res += k * 9;
        }
        int[] arr = new int[res];
        for(int i = 0;i < res;i++){
            arr[i] = i + 1;
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(new Solution17().printNumbers(3));
    }
}
