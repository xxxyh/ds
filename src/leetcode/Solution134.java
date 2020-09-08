package leetcode;


public class Solution134 {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        for (int i = 0; i < len; i++) {
            int max = len + i;
            int sum = 0;
            int j = 0;
            for (j = i; j < max; j++) {
                int current = j >= len ? j - len : j;
                if (gas[current] + sum < cost[current]) {
                    break;
                } else {
                    sum += gas[current] - cost[current];
                }
            }
            if (j == max) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit(gas, cost));
    }
}
