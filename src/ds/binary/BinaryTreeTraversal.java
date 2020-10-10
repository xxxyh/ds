package ds.binary;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public abstract class BinaryTreeTraversal {

    TreeNode root;
    List<Integer> res = new ArrayList<>();
    public BinaryTreeTraversal(){
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        node5.left = node4;
        node5.right = node6;
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node4.left = node1;
        node4.right = node2;
        root = node5;
    }

    public abstract List<Integer> traversal();
}
