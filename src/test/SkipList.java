package test;

import java.util.Random;

public class SkipList {
    private static final int MAX_LEVEL = 10;
    private int length;
    private SkipListNode head,tail;
    private static final Random RANDOM = new Random(MAX_LEVEL);

    public SkipList(){
        this.length = 0;
        this.head = new SkipListNode(-1);
        SkipListNode node = head;
        for(int i = 1; i < MAX_LEVEL;i++){
            SkipListNode skipListNode = new SkipListNode(1);
            node.next = skipListNode;
            node = node.next;
        }
        tail = node;
    }

    //给一个随机数
    private int randomLevel(){
        return RANDOM.nextInt();
    }
}

class SkipListNode{
    SkipListNode preview;
    SkipListNode next;
    int value;
    SkipListNode down;//下一层的节点
    public SkipListNode(int value){
        this.value = value;
    }
}
