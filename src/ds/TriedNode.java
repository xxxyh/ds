package ds;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TriedNode {
    private static final int ALPHABET_SIZE = 26;

    //根节点
    private char val;

    //以当前字符结尾的单词的个数
    private int frequency;

    //子节点
    private TriedNode[] children = new TriedNode[ALPHABET_SIZE];

    public TriedNode(char val){
        this.val = val;
    }

    static class TriedTree{
        TriedNode root = new TriedNode('/');

        public boolean findStr(String str){
            TriedNode p = root;
            for(int i = 0;i < str.length();i++){
                char c = str.charAt(i);
                int diff = c - 'a';
                if(p.children[diff] == null){
                    return false;
                }
                p = p.children[diff];
            }
            return true;
        }

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

        public List<String> findByPrefix(String prefix){
            List<String> res = new ArrayList<>();
            TriedNode p = root;
            for(int i = 0;i < prefix.length();i++){
                char c = prefix.charAt(i);
                int diff = c - 'a';
                if(p.children[diff] == null){
                    return res;
                }
                p = p.children[diff];
            }
            if(p.frequency > 0){
                res.add(prefix);
            }
            dfs(new StringBuilder(prefix), p, res);
            return res;
        }

        private void dfs(StringBuilder cur, TriedNode node, List<String> res){
            if(node == null){
                return;
            }
            TriedNode[] children = node.children;
            for(int i = 0;i < ALPHABET_SIZE;i++){
                TriedNode curNode = children[i];
                if(curNode != null){
                    cur.append(curNode.val);
                    if(curNode.frequency > 0){
                        res.add(cur.toString());
                    }
                    dfs(cur, curNode, res);
                    cur.deleteCharAt(cur.length() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        TriedTree tree = new TriedTree();
        tree.insertStr("tea");
        tree.insertStr("teach");
        tree.insertStr("teacher");
        tree.insertStr("tef");
        tree.insertStr("ted");
        System.out.println(tree.findStr("tesf"));
        tree.findByPrefix("tea").stream().forEach(System.out::println);
    }
}
