package leetcode;

public class Solution1492 {
    public int kthFactor(int n, int k) {
        int count = 0;
        int current = 1;
        while(true){
            if(n % current == 0){
                count++;
            }
            if(current > n){
                return -1;
            }
            if(count == k){
                return current;
            }
            current++;
        }
    }
}
