package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution128 {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        UF uf = new UF(nums.length);
        for(int i = 0;i < nums.length;i++){
            if(map.containsKey(nums[i])){
                continue;
            }
            if(map.containsKey(nums[i] + 1)){
                int index = map.get(nums[i] + 1);
                uf.union(i, index);
            }
            if(map.containsKey(nums[i] - 1)){
                int index = map.get(nums[i] - 1);
                uf.union(i, index);
            }
            map.put(nums[i], i);
        }
        return uf.getMaxSize();
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

        public boolean connected(int p, int q){
            int findP = find(p);
            int findQ = find(q);
            return findP == findQ;
        }

        public void union(int p, int q){
            int findP = find(p);
            int findQ = find(q);
            if(findP == findQ){
                return;
            }

            if(size[findP] < size[findQ]){
                parent[findP] = parent[findQ];
                size[findQ] += size[findP];
            }else{
                parent[findQ] = parent[findP];
                size[findP] += size[findQ];
            }
        }

        public int getMaxSize(){
            int max = 0;
            for(int m : size){
                max = Math.max(m, max);
            }
            return max;
        }
    }
}
