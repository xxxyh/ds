package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution652 {
    List<TreeNode> res = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traversal(root);
        return res;
    }

    private String traversal(TreeNode node){
        if(node == null){
            return "#";
        }

        String left = traversal(node.left);
        String right = traversal(node.right);
        String val = "" + node.val;
        String cur = left + "," +right + "," + val;
        int freq = map.getOrDefault(cur, 0);
        if(freq == 1){
            res.add(node);
        }
        map.put(cur, freq + 1);
        return cur;
    }
}
