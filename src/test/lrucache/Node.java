package test.lrucache;

public class Node{
    public int key, val;
    public Node prev, next;
    public Node(int k, int v){
        this.key = k;
        this.val = v;
    }
}