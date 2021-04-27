package leetcode;

public class Solution1579 {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind bob = new UnionFind(n);
        UnionFind alice = new UnionFind(n);

        int res = 0;
        for (int[] edge : edges) {
            int type = edge[0];
            int p = edge[1] - 1;
            int q = edge[2] - 1;
            if (type == 3) {//all
                if (bob.connected(p, q) && alice.connected(p, q)) {
                    res++;
                } else {
                    bob.union(p, q);
                    alice.union(p, q);
                }
            }
        }

        for (int[] edge : edges) {
            int type = edge[0];
            int p = edge[1] - 1;
            int q = edge[2] - 1;
            if (type == 2) {//bob
                if (bob.connected(p, q)) {
                    res++;
                } else {
                    bob.union(p, q);
                }
            } else if (type == 1) {//alice
                if (alice.connected(p, q)) {
                    res++;
                } else {
                    alice.union(p, q);
                }
            }
        }
        if (bob.getCount() == 1 && alice.getCount() == 1) {
            return res;
        } else {
            return -1;
        }
    }

    class UnionFind {
        int[] parent;
        int[] size;
        int count;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
            count = n;
        }

        private int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }

            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = parent[rootP];
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = parent[rootQ];
                size[rootQ] += size[rootP];
            }
            count--;
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution1579().maxNumEdgesToRemove(4, new int[][]{{3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4}}));
    }
}
