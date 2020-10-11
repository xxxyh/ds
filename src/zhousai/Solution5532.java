package zhousai;


import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution5532 {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            int last = 0;
            if(level % 2 == 0){
                last = Integer.MIN_VALUE;
            }else{
                last = Integer.MAX_VALUE;
            }
            while(size > 0){
                TreeNode node = queue.poll();
                int val = node.val;
                if(level % 2 == 0){
                    if(val % 2 == 0 || val <= last){
                        return false;
                    }else{
                        last = val;
                    }
                }
                if(level % 2 != 0){
                    if(val % 2 != 0 || val  >= last){
                        return false;
                    }else{
                        last = val;
                    }
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                size--;
            }
            level++;
        }
        return true;
    }
}
