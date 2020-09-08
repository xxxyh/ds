package leetcode;

public class Solution495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int count = 0;
        if(timeSeries.length == 0){
            return count;
        }
        for(int i = 0;i < timeSeries.length - 1;i++){
            if(timeSeries[i + 1] - timeSeries[i] >= duration){
                count += duration;
            }else{
                count += timeSeries[i + 1] - timeSeries[i];
            }
        }
        return count + duration;
    }
}
