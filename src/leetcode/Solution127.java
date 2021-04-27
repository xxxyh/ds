package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        int end = wordList.indexOf(endWord);
        if(end == -1){
            return 0;
        }
        wordList.add(beginWord);
        int start = wordList.size() - 1;
        Queue<String> queue1 = new LinkedList<>();
        queue1.offer(beginWord);
        Queue<String> queue2 = new LinkedList<>();
        queue2.offer(endWord);
        Set<String> visited1 = new HashSet<>();
        visited1.add(beginWord);
        Set<String> visited2 = new HashSet<>();
        visited2.add(endWord);
        int count = 0;
        while(!queue1.isEmpty() && !queue2.isEmpty()){
            count++;
            if(queue1.size() > queue2.size()){
                Queue<String> temp = queue1;
                queue1 = queue2;
                queue2 = temp;
                Set<String> set = visited1;
                visited1 = visited2;
                visited2 = set;
            }
            int size = queue1.size();
            while(size-- > 0){
                String s = queue1.poll();
                char[] chars = s.toCharArray();
                for(int i = 0;i < chars.length;i++){
                    char t = chars[i];
                    for(char c = 'a';c <= 'z';c++){
                        chars[i] = c;
                        String cur = new String(chars);
                        if(visited1.contains(cur)){//已经访问过了
                            continue;
                        }
                        if(visited2.contains(cur)){//双向遍历遇到了
                            return count + 1;
                        }
                        if(wordSet.contains(cur)){
                            queue1.offer(cur);
                            visited1.add(cur);
                        }
                    }
                    chars[i] = t;
                }
            }
        }
        return 0;
    }
}
