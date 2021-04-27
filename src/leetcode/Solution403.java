package leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution403 {
    public ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        while(!queue.isEmpty()){
            int count = queue.size();
            ListNode root = null;
            ListNode head = null;
            while(count-- > 0){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                ListNode listNode = new ListNode(node.val);
                if(head == null){
                    root = listNode;
                    head = listNode;
                    list.add(root);
                }else{
                    head.next = listNode;
                    head = listNode;
                }
            }
        }
        ListNode[] nodes = new ListNode[list.size()];
        for(int i = 0;i < list.size();i++){
            nodes[i] = list.get(i);
        }
        return nodes;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        new Solution403().listOfDepth(node1);
    }

}
