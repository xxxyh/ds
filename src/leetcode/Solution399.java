package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution399 {


    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Integer> map = new HashMap<>();
        for(List<String> equation : equations){
            for(String str : equation){
                if(!map.containsKey(str)){
                    int size = map.size();
                    map.put(str, size);
                }
            }
        }
        UF uf = new UF(map.size());
        for(int i = 0;i < equations.size();i++){
            List<String> equation = equations.get(i);
            uf.union(map.get(equation.get(0)), map.get(equation.get(1)));
        }
        double[] res = new double[queries.size()];
        for(int i = 0;i < queries.size();i++){
            List<String> query = queries.get(i);
            String start = query.get(0);
            String end = query.get(1);
            if(!map.containsKey(start) || !map.containsKey(end)){
                res[i] = -1;
                continue;
            }
            int p = map.get(start);
            int q = map.get(end);
            if(!uf.connected(p, q)){
                res[i] = -1;
                continue;
            }
            for(int j = 0;j < equations.size();j++){
                double cur = 1;
                List<String> equation = equations.get(j);
                if(equation.get(0).equals(start)){
                    dfs(equation.get(1), end, cur * values[j], new HashSet<>(), equations, values, res, i);
                }
                if(equation.get(1).equals(start)){
                    dfs(equation.get(0), end, cur / values[j], new HashSet<>(), equations, values, res, i);
                }
            }
        }
        return res;
    }

    private void dfs(String start, String end, double cur, Set<Integer> used, List<List<String>> equations, double[] values, double[] res, int index){
        if(start.equals(end)){
            res[index] = cur;
            return;
        }

        if(used.size() == equations.size()){
            return;
        }

        for(int i = 0;i < equations.size();i++){
            if(used.contains(i)){
                continue;
            }
            List<String> equation = equations.get(i);
            if(start.equals(equation.get(0))){
                used.add(i);
                dfs(equation.get(1), end, cur * values[i], used, equations, values, res, index);
                used.remove(i);
            }
            if(start.equals(equation.get(1))){
                used.add(i);
                dfs(equation.get(0), end, cur / values[i], used, equations, values, res, index);
                used.remove(i);
            }
        }
    }


    class UF{
        int[] parent;
        int[] size;

        public UF(int n){
            parent = new int[n];
            size = new int[n];
            for(int i = 0;i < n;i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        private int find(int x){
            while(x != parent[x]){
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int p, int q){
            int rootP = find(p);
            int rootQ = find(q);

            if(rootP == rootQ){
                return;
            }

            if(size[rootP] > size[rootQ]){//接到p下面
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }else{
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
        }

        public boolean connected(int p, int q){
            int rootP = find(p);
            int rootQ = find(q);

            return rootP == rootQ;
        }
    }


    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a","b"));
        equations.add(Arrays.asList("b","c"));
        double[] values = new double[]{2.0,3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a","c"));
        queries.add(Arrays.asList("b","a"));
        queries.add(Arrays.asList("a","e"));
        queries.add(Arrays.asList("a","a"));
        queries.add(Arrays.asList("x","x"));
        new Solution399().calcEquation(equations, values, queries);
    }
}
