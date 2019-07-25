package List;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayList {
    private int size;
    private int[] nums;
    private int caption;

    public void createList(){
        Scanner sc = new Scanner(System.in);
        LinkedList linkedList = new LinkedList();
        System.out.println("输入链表的长度:");
        int n = sc.nextInt();
        nums = new int[n * 2];
        caption = 2 * n;
        System.out.println("请依次输入链表元素");
        for(int i = 0;i < n;i++){
            nums[i] = sc.nextInt();
            size++;
        }
    }

    public int get(int index){
        indexCheck(index);
        return nums[index];
    }

    public int size(){
        return size;
    }

    public int remove(int index){
        indexCheck(index);
        int result = nums[index];
        for(int i = index; i < size;i++){
            nums[i] = nums[i + 1];
        }
        size--;
        return result;
    }

    public void add(int data){
        if(size >= caption){
            nums = Arrays.copyOf(nums, 2 * caption);
        }
        nums[size++] = data;
    }

    public void print(){
        for(int i = 0;i < size;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }

    private void indexCheck(int index){
        if(index >= size || index < 0){
            throw new RuntimeException("ArrayIndexOutOfBound "+"size:"+size+" index"+index);
        }
    }

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.createList();
        System.out.println("size:"+list.size());
        list.add(10);
        list.add(7);
        list.print();
        System.out.println(list.get(2));
        System.out.println("size:"+list.size());
        System.out.println(list.remove(1));
        list.print();
        System.out.println("size:"+list.size());
    }
}
