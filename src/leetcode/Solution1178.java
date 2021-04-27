package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution1178 {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        int[] newWords = new int[words.length];
        int index = 0;
        int[][] fres = new int[words.length][26];
        for (String word : words) {
            newWords[index] = getWordValue(word, fres, index);
            index++;
        }

        List<Integer> res = new ArrayList<>(puzzles.length);
        for (int i = 0; i < puzzles.length; i++) {
            String puzzle = puzzles[i];
            if (puzzle.length() == 0) {
                res.add(0);
                continue;
            }
            int cur = getWordValue(puzzle, null, -1);
            int val = 0;
            for (int j = 0; j < words.length; j++) {
                String word = words[j];
                if (word.length() == 0) {
                    continue;
                }
                if (fres[j][puzzle.charAt(0) - 'a'] == 0) {
                    continue;
                }
                if ((cur & newWords[j]) >= newWords[j]) {
                    val++;
                }
            }
            res.add(val);
        }
        return res;
    }

    private int getWordValue(String word, int[][] fres, int index) {
        int[] arr = new int[26];
        for (int i = 0; i < word.length(); i++) {
            arr[word.charAt(i) - 'a']++;
        }
        int cur = 0;
        for (int i = 0; i < 25; i++) {
            if (arr[i] > 0) {
                cur += Math.pow(2, i);
            }
        }
        if (index != -1) {
            fres[index] = arr;
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1178().findNumOfValidWords(new String[]{"apple", "pleas", "please"},
                new String[]{"aelwxyz", "aelpxyz", "aelpsxy", "saelpxy", "xaelpsy"}));
    }

}
