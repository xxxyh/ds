package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution685 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0;i < edges.length;i++){
            int key = edges[i][1];
            map.computeIfAbsent(key, k->new ArrayList<>());
            map.get(key).add(i);
        }
        boolean has2 = false;
        for(List<Integer> value : map.values()){
            if(value.size() == 2){
                has2 = true;
            }
        }
        if(has2){
            //有入度为2的节点
            for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
                List<Integer> list = entry.getValue();//找一下入度为2的节点
                if(list.size() == 2){
                    for(int i = 1;i >= 0;i--){
                        int index = list.get(i);
                        UF uf = new UF(edges.length);
                        boolean flag = false;
                        for(int j = 0;j < edges.length;j++){//删了下标为j的边，看剩下的还有没有环
                            if(j == index){
                                continue;
                            }
                            int p = edges[j][0] - 1;
                            int q = edges[j][1] - 1;
                            if(uf.connected(p, q)){
                                flag = true;
                            }else{
                                uf.union(p, q);
                            }
                        }
                        if(!flag){//剩下的边没有环了，可以返回当前边
                            return edges[index];
                        }
                    }
                }
            }
        }else{//没有入度为2的边，就是个环，退化成684那题的解法
            UF uf = new UF(edges.length);
            for(int[] edge : edges){
                int p = edge[0] - 1;
                int q = edge[1] - 1;
                if(uf.connected(p, q)){
                    return edge;
                }else{
                    uf.union(p, q);
                }
            }
        }
        return null;
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
    }
}
