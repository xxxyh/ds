package jianzhioffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution32to2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return Collections.emptyList();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> res = new ArrayList<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> row = new ArrayList<>(size);
            res.add(row);
            while(size > 0){
                TreeNode node = queue.poll();
                row.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                size--;
            }
        }
        return res;
    }
}
