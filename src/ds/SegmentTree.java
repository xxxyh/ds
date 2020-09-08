package ds;

public class SegmentTree {
    private static int n = 10;
    private static int[] arr = {0, 1, 5, 1, 3, 4, 2, 0, 9, 0, 9};
    private static Node[] tree = new Node[4 * n];

    private static void init(){
        for(int i = 0;i < tree.length;i++){
            tree[i] = new Node(0, 0, 0, 0);
        }
    }

    private static void updateNode(int i){
        tree[i].sum = tree[2 * i].sum + tree[2 * i + 1].sum;
    }

    private static void build(int l, int r, int num){
        tree[num].l = l;
        tree[num].r = r;

        if(l == r){//到达叶子节点
            tree[num].sum = arr[l];
            return;
        }
        int mid = l + (r - l) / 2;
        build(l, mid, num * 2);
        build(mid + 1, r, num * 2 + 1);
        updateNode(num);
    }

    private static void modify(int i, int value, int num){//把元素i的值修改为value
        if(tree[num].l == tree[num].r){
            tree[num].sum = value;
            return;
        }

        int mid = tree[num].l + (tree[num].r - tree[num].l) / 2;
        if(i <= mid){//左子树
            modify(i, value, 2 * num);
        }else{
            modify(i, value, 2 * num + 1);
        }
        updateNode(num);
    }

    private static void modifySegment(int l, int r, int value, int num){//把l-r之间的元素都增加value
        if(tree[num].l == l && tree[num].r == r){
            tree[num].sum += value;
            tree[num].lazy = value;
            return;
        }

        int mid = tree[num].l + (tree[num].r - tree[num].l) / 2;
        if(r <= mid){//全在左子树
            modifySegment(l, r, value,num * 2);
        }else if(l > mid){
            modifySegment(l ,r, value, num * 2 + 1);
        }else{
            modifySegment(l, mid, value, num * 2);
            modifySegment(mid + 1 ,r, value, num * 2 + 1);
        }
        updateNode(num);
    }

    private static void pushDown(int num){
        if(tree[num].l == tree[num].r){
            tree[num].lazy = 0;
            return;
        }

        tree[num * 2].lazy = tree[num].lazy;
        tree[num * 2].sum += (tree[num * 2].r - tree[num * 2].l + 1) * tree[num * 2].lazy;
        tree[num * 2 + 1].lazy = tree[num].lazy;
        tree[num * 2 + 1].sum += (tree[num * 2 + 1].r - tree[num * 2 + 1].l + 1) * tree[num * 2 + 1].lazy;
        tree[num].lazy = 0;
    }
    private static int query(int l, int r, int num){
        if(tree[num].lazy != 0){
            pushDown(num);
        }
        if(tree[num].l == l && tree[num].r == r){
            return tree[num].sum;
        }
        int mid = tree[num].l + (tree[num].r - tree[num].l) / 2;
        if(r <= mid){
            return query(l, r, 2 * num);
        }else if(l > mid){
            return query(l , r, 2 * num + 1);
        }else{
            return query(l, mid, 2 * num) + query(mid + 1, r, 2 * num + 1);
        }
    }
    public static void main(String[] args) {
        init();
        build(1, 10, 1); // 利用build函数建树
        System.out.println("操作1：[2，5]的区间和是：" + query(2, 5, 1));
        // 利用query函数搜索区间和
        modify(5, 9, 1); // 利用modify函数实现单点修改（元素5从4改为9）
        System.out.println("操作2：元素5从4改为9，此时[2，5]的区间和是：" + query(2, 5, 1));
        modifySegment(3, 4, 3, 1);
        // 利用modifySegment函数将[3，4]每个元素增加3
        System.out.println("操作3：区间[3，4]每个元素+3，此时[2，5]的区间和是：" + query(2, 5, 1));
    }


    static class Node{
        int l;
        int r;
        int sum;
        int lazy;

        public Node(int l, int r, int sum, int lazy){
            this.l = l;
            this.r = r;
            this.sum = sum;
            this.lazy = lazy;
        }
    }
}
