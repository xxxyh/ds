package leetcode;

public class Solution164 {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int diff = max - min < nums.length ? 1 : (max - min) / nums.length;
        int count = (max - min) / diff + 1;
        int begin = count;
        int[] minVal = new int[count];
        int[] maxVal = new int[count];
        boolean[] used = new boolean[count];
        for (int i = 0; i < count; i++) {
            maxVal[i] = Integer.MIN_VALUE;
            minVal[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < nums.length; i++) {
            int index = (nums[i] - min) / diff;
            used[index] = true;
            begin = Math.min(begin, index);
            minVal[index] = Math.min(nums[i], minVal[index]);
            maxVal[index] = Math.max(nums[i], maxVal[index]);
        }
        int res = 0;
        int cur = begin + 1;
        int last = begin;
        for (; cur < count; cur++) {
            if (!used[cur]) {
                continue;
            }
            res = Math.max(res, minVal[cur] - maxVal[last]);
            last = cur;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution164().maximumGap(new int[]{100, 3, 3, 1}));
    }
}
