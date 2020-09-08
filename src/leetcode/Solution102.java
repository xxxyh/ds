package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Set<TreeNode> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        set.add(root);
        Map<TreeNode, Integer> levelMap = new HashMap<>();
        levelMap.put(root, 0);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            //遍历node
            if(result.size() < levelMap.get(node) + 1){
                result.add(new ArrayList<>());
            }
            List<Integer> row = result.get(levelMap.get(node));
            row.add(node.val);
            if(node.left != null){
                queue.offer(node.left);
                levelMap.put(node.left, levelMap.get(node) + 1);
            }
            if(node.right != null){
                queue.offer(node.right);
                levelMap.put(node.right, levelMap.get(node) + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node1 = new Solution102().new TreeNode(3);
        TreeNode node2 = new Solution102().new TreeNode(9);
        TreeNode node3 = new Solution102().new TreeNode(20);
        TreeNode node4 = new Solution102().new TreeNode(15);
        TreeNode node5 = new Solution102().new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        System.out.println(new Solution102().levelOrder(node1));
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
