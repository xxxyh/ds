package test.lrucache;

public class DoubleList {

    private Node head, tail;
    private int size;

    public DoubleList(){
        Node head = new Node(0, 0);
        Node tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    //往结尾添加一个节点
    public void addLast(Node node){
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
        size++;
    }

    //删除指定节点
    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    //删除第一个节点
    public Node removeFirst(){
        if(head == tail){
            return null;
        }
        Node node = head.next;
        head.next = head.next.next;
        head.next.prev = head;
        return node;//也可以remove(node)
    }

    public int size(){
        return size;
    }

}