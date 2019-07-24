package List;

import java.util.Scanner;

public class LinkedList{
    private int size;
    private Node head = new Node();
    private Node tail;


    public void createList(){
        Scanner sc = new Scanner(System.in);
        LinkedList linkedList = new LinkedList();
        System.out.println("输入链表的长度:");
        int n = sc.nextInt();
        System.out.println("请依次输入链表元素");
        tail = head;
        for(int i = 0;i < n;i++){
            int data = sc.nextInt();
            Node node = new Node();
            node.data = data;
            tail.next = node;
            tail = node;
            size++;
        }
    }

    public int size(){
        return this.size;
    }

    public int get(int index){
        if(index >= size){
            throw new RuntimeException("ArrayIndexOutOfBound "+"size:"+size+" index"+index);
        }
        int k = 0;
        Node node = head.next;
        while(k < index){
            node = node.next;
            k++;
        }
        return node.data;
    }

    public void print(){
        Node node = head.next;
        while(node != null){
            System.out.print(node.data+" ");
            node = node.next;
        }
        System.out.println();
    }
    public void add(int data){
        Node node = new Node();
        node.data = data;
        tail.next = node;
        tail = node;
        size++;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.createList();
        linkedList.add(10);
        linkedList.add(7);
        linkedList.print();
        System.out.println(linkedList.get(3));
    }

    class Node{
        int data;
        Node next;
    }
}
