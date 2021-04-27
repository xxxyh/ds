package leetcode;

public class Solution1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int left = 0;
        int right = X;
        int sum = 0;
        for(int i = 0;i < X;i++){
            sum += customers[i];
        }
        for(int i = X;i < customers.length;i++){
            if(grumpy[i] == 0){
                sum += customers[i];
            }
        }
        int res = sum;
        while(right < customers.length){
            if(grumpy[right] == 1){
                sum += customers[right];
            }
            if(grumpy[left] == 1){
                sum -= customers[left];
            }
            res = Math.max(sum, res);
            left++;
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1052().maxSatisfied(new int[]{1,0,1,2,1,1,7,5}, new int[]{0,1,0,1,0,1,0,1}, 3));
    }
}
