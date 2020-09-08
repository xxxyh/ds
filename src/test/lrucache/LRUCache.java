package test.lrucache;

import java.util.HashMap;

public class LRUCache{
    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int cap;

    public LRUCache(int capacity){
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        //把这个节点提升到最近使用，并返回
        makeRecently(key);
        return map.get(key).val;
    }

    public void put(int key, int val){
        if(map.containsKey(key)){
            deleteKey(key);
            addRecently(key, val);
            return;
        }
        if(cap == cache.size()){
            removeLeastRecently();
        }
        addRecently(key, val);
    }

    //把当前节点提升为最近使用的节点，就是提到队尾
    private void makeRecently(int key){
        Node node = map.get(key);
        cache.remove(node);
        cache.addLast(node);
    }

    //添加最近使用的节点
    private void addRecently(int key, int val){
        Node node = new Node(key, val);
        map.put(key, node);
        cache.addLast(node);
    }

    //删除某一个key
    private void deleteKey(int key){
        Node node = map.remove(key);
        cache.remove(node);
    }

    //删除最久未使用的元素
    public void removeLeastRecently(){
        Node node = cache.removeFirst();
        map.remove(node.key);
    }
}




