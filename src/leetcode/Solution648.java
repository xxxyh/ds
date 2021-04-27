package leetcode;

import java.util.Arrays;
import java.util.List;

public class Solution648 {
    public String replaceWords(List<String> dictionary, String sentence) {
        TriedTree tree = new TriedTree();
        for(String root : dictionary){
            tree.insertStr(root);
        }
        String[] splits = sentence.split(" ");
        for(int i = 0;i < splits.length;i++){
            String replace = tree.findFirstRoot(splits[i]);
            if(replace != null){
                splits[i] = replace;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String split : splits){
            sb.append(split).append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }

    static class TriedNode{
        private char val;
        private TriedNode[] children = new TriedNode[26];
        private int frequency;
        public TriedNode(char val){
            this.val = val;
        }
    }

    static class TriedTree{
        TriedNode root = new TriedNode('/');

        public void insertStr(String str){
            TriedNode p = root;
            for(int i = 0;i < str.length();i++){
                char c = str.charAt(i);
                int diff = c - 'a';
                if(p.children[diff] == null){
                    p.children[diff] = new TriedNode(c);
                }
                p = p.children[diff];
            }
            p.frequency++;
        }

        public String findFirstRoot(String str){
            TriedNode p = root;
            for(int i = 0;i < str.length();i++){
                char c = str.charAt(i);
                int diff = c - 'a';
                if(p.children[diff] == null){//不存在当前词根
                    return null;
                }
                if(p.children[diff].frequency > 0){
                    return str.substring(0, i + 1);
                }
                p = p.children[diff];
            }
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution648().replaceWords(Arrays.asList("ac","ab"),
                "it is ab that this solution is ac"));
    }
}
