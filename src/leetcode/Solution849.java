package leetcode;

public class Solution849 {
    public int maxDistToClosest(int[] seats) {
        int max = 0;
        int start = -1;
        for(int i = 0;i < seats.length;i++){
            if(seats[i] == 0){
                int current = i - start;
                if(start == -1 || i == seats.length - 1){
                    current *= 2;
                }
                if(current >= max){
                    max = current;
                }
            }else{
                start = i;
            }
        }
        return (max + 1) / 2;
    }

    public static void main(String[] args) {
        System.out.println(new Solution849().maxDistToClosest(new int[]{1,0,0,0}));
    }
}
