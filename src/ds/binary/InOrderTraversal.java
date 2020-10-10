package ds.binary;

import leetcode.TreeNode;

import java.util.List;
import java.util.Stack;

public class InOrderTraversal extends BinaryTreeTraversal {
    @Override
    public List<Integer> traversal() {
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new InOrderTraversal().traversal());
    }
}
