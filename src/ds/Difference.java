package ds;

public class Difference {
    private int[] diff;

    public Difference(int[] nums){
        diff = new int[nums.length];
        diff[0] = nums[0];
        for(int i = 1;i < nums.length;i++){
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    //从i-j都加value
    public void increment(int i, int j, int value){
        diff[i] += value;
        if (j + 1 < diff.length) {
            diff[j + 1] -= value;
        }
    }

    //返回原数组
    public int[] result(){
        int[] res = new int[diff.length];
        res[0] = diff[0];
        for(int i = 1;i < diff.length;i++){
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }
}
