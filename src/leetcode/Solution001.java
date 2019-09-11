package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution001 {
    /**
     *思路：例如示例中target是9，数组第一个值是2，那么需要9-2=7来和2合并成9，将7作为key，将2的下标0
     * 作为value存入map，后面判断遇到的值在map中有没有作为key存过就行了
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap(nums.length);
        for(int i = 0;i < nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(target - nums[i],i);
            }else{
                return new int[]{map.get(nums[i]),i};
            }
        }
        return null;
    }
}
