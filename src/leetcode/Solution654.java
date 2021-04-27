package leetcode;

public class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    private TreeNode construct(int[] nums, int i, int j){
        if(i > j){
            return null;
        }
        int max = Integer.MIN_VALUE;
        int maxIndex = i;
        for(int k = i;k <= j;k++){
            if(nums[k] > max){
                maxIndex = k;
                max = nums[k];
            }
        }
        TreeNode node = new TreeNode(max);
        node.left = construct(nums, i, maxIndex - 1);
        node.right = construct(nums,maxIndex + 1, j);
        return node;
    }
}
