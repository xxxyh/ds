package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution077 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n , k, new ArrayList<>());
        return result;
    }
    private void dfs(int i, int n, int k, List<Integer> current){
        if(current.size() == k){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int j = i;j <= n;j++){
            current.add(j);
            dfs(j + 1, n, k, current);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution077().combine(4, 2));
    }
}
