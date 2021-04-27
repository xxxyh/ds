package leetcode;

public class Solution208 {

    class Trie {

        private static final int ALPHABET_SIZE = 26;//只包含小写字母

        private TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode node = root;
            for(int i = 0;i < word.length();i++){
                char c = word.charAt(i);
                if(node.children[c - 'a'] == null){
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.frequency++;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode node = root;
            for(int i = 0;i < word.length();i++){
                char c = word.charAt(i);
                if(node.children[c - 'a'] == null){
                    return false;
                }
                node = node.children[c - 'a'];
            }
            return node.frequency > 0;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for(int i = 0;i < prefix.length();i++){
                char c = prefix.charAt(i);
                if(node.children[c - 'a'] == null){
                    return false;
                }
                node = node.children[c - 'a'];
            }
            return true;
        }

        class TrieNode{

            private int frequency;

            private TrieNode[] children;

            public TrieNode(){
                children = new TrieNode[ALPHABET_SIZE];
                frequency = 0;
            }
        }
    }
}
