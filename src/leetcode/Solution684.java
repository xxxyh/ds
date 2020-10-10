package leetcode;

public class Solution684 {

    int[] parent;
    int[] size;

    public void init(int n){
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
        int findQ = find(q);
        int findP = find(p);
        return findQ == findP;
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

    public int[] findRedundantConnection(int[][] edges) {
        init(edges.length);
        for(int[] edge : edges){
            int p = edge[0] - 1;
            int q = edge[1] - 1;
            if(connected(p, q)){
                return edge;
            }else{
                union(p, q);
            }
        }
        return null;
    }
}
