package leetcode;

public class Solution1011 {
    public int shipWithinDays(int[] weights, int D) {
        int sumWeights = 0;
        int maxWeight = Integer.MIN_VALUE;
        for(int i = 0;i < weights.length;i++){
            maxWeight = Math.max(maxWeight, weights[i]);
            sumWeights += weights[i];
        }
        int left = maxWeight;
        int right = sumWeights;
        while(left < right){
            int mid = left + (right - left) / 2;
            int cur = execute(weights, mid);
            if(cur > D){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }

    private int execute(int[] weights, int d){
        int res = 0;
        int sum = 0;
        for(int i = 0;i < weights.length;i++){
            sum += weights[i];
            if(sum > d){
                sum = weights[i];
                res++;
            }
        }
        res++;
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new Solution1011().shipWithinDays(new int[]{1,2,3,1,1}, 4));
    }
}
