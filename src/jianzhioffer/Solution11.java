package jianzhioffer;

public class Solution11 {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(numbers[mid] > numbers[right]){
                left = mid + 1;
            }else if(numbers[mid] < numbers[right]){
                right = mid;
            }else{
                right--;
            }
        }
        return numbers[right];
    }

    public static void main(String[] args) {
        System.out.println(new Solution11().minArray(new int[]{10,10,10,1,10}));
    }
}
