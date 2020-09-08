package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution110 {
    private Map<TreeNode, Integer> map = new HashMap<>();
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(height(root.left) - height(root.right)) <= 1;
    }
    private int height(TreeNode node){
        if(node == null){
            return 0;
        }
        if(map.containsKey(node)){
            return map.get(node);
        }
        int height = Math.max(height(node.left) + 1, height(node.right) + 1);
        map.put(node, height);
        return height;
    }

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
