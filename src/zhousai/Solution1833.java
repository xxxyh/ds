package zhousai;

import java.util.Arrays;

public class Solution1833 {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        int cost = 0;
        int i = 0;
        for(;i < costs.length;i++){
            cost += costs[i];
            if(cost > coins){
                break;
            }
        }
        return i;
    }
}
