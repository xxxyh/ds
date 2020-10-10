package leetcode;

public class Solution839 {

    public int numSimilarGroups(String[] A) {
        if(A == null || A.length == 0){
            return 0;
        }
        UF uf = new UF(A.length);
        for(int i = 0;i < A.length - 1;i++){
            for(int j = 0;j < A.length;j++){
                if(similar(A[i], A[j])){
                    uf.union(i, j);
                }
            }
        }
        return uf.getCount();
    }

    private boolean similar(String str1, String str2){
        int diff = 0;
        for(int i = 0;i < str1.length();i++){
            if(str1.charAt(i) != str2.charAt(i)){
                diff++;
            }
        }
        return diff <= 2;
    }

    class UF{
        int[] parent;
        int[] size;
        int count;

        public UF(int n){
            parent = new int[n];
            size = new int[n];
            count = n;
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
        public boolean connected(int p,int q){
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

        public void union(int p,int q){
            int rootP = find(p);
            int rootQ = find(q);
            if(rootP == rootQ){
                return;
            }
            if(size[rootP] < size[rootQ]){
                parent[rootP] = parent[rootQ];
                size[rootQ] += size[rootQ];
            }else{
                parent[rootQ] = parent[rootP];
                size[rootP] += size[rootQ];
            }
            count--;
        }

        private int getCount(){
            return count;
        }
    }
}
