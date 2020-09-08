package list;

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
        indexCheck(index);
        int k = 0;
        Node node = head.next;
        while(k < index){
            node = node.next;
            k++;
        }
        return node.data;
    }

    public int remove(int index){
        indexCheck(index);
        int k = 0;
        Node i = head;
        Node j = head.next;
        while(k < index){
            i = i.next;
            j = j.next;
            k++;
        }

        i.next = j.next;
        size--;
        return j.data;
    }


    private void indexCheck(int index){
        if(index >= size){
            throw new RuntimeException("ArrayIndexOutOfBound "+"size:"+size+" index"+index);
        }
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
        LinkedList list = new LinkedList();
        list.createList();
        System.out.println("size:"+list.size());
        list.add(10);
        list.add(7);
        list.print();
        System.out.println(list.get(3));
        System.out.println("size:"+list.size());
        System.out.println(list.remove(5));
        list.print();
        System.out.println("size:"+list.size());
    }

    class Node{
        int data;
        Node next;
    }
}
