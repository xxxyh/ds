package leetcode;

public class Solution547 {

    public int findCircleNum(int[][] M) {
        if(M == null || M.length == 0){
            return 0;
        }
        int n = M.length;
        UF uf = new UF(n);
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                if(M[i][j] == 1){
                    uf.union(i, j);
                }
            }
        }
        return uf.count();
    }

    class UF{
        int[] parent;
        int[] size;
        int count;
        public UF(int n){
            parent = new int[n];
            size = new int[n];
            for(int i = 0;i < n;i++){
                parent[i] = i;
                size[i] = 1;
            }
            count = n;
        }

        private int find(int x){
            while(x != parent[x]){
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
        public boolean connected(int p ,int q){
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
                parent[findP] = findQ;
                size[findQ] += size[findP];
            }else{
                parent[findQ] = findP;
                size[findP] += size[findQ];
            }
            count--;
        }
        public int count(){
            return count;
        }
    }
}
