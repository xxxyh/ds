package jianzhioffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution32to3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return Collections.emptyList();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> res = new ArrayList<>();
        int index = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> row = new ArrayList<>(size);
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
            if((index & 1) == 0){//偶数行
                res.add(row);
            }else {
                List<Integer> cur = new ArrayList<>(row.size());
                for(int i = row.size() - 1;i >= 0;i--){
                    cur.add(row.get(i));
                }
                res.add(cur);
            }
            index++;
        }
        return res;
    }
}
