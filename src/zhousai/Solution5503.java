package zhousai;

import java.util.List;

public class Solution5503 {
    int sum = 0;
    public int sumOddLengthSubarrays(int[] arr) {
        int[] preSum = new int[arr.length + 1];
        preSum[0] = 0;
        for(int i = 0;i < arr.length;i++){
            preSum[i + 1] = preSum[i] + arr[i];
        }

        int sum = 0;
        for(int i = 0;i < arr.length;i++){
            for(int j = i;j < arr.length;j++){
                if((j - i)% 2 == 0){
                    sum += preSum[j + 1] - preSum[i];
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution5503().sumOddLengthSubarrays(new int[]{10,11,12}));
    }
}
