package leetcode;

public class Solution002 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int currentSum = l1.val + l2.val;
        boolean flag = false;//是否进位
        if(currentSum >= 10){
            flag = true;
            currentSum -= 10;
        }
        ListNode listNode = new ListNode(currentSum);
        ListNode result = listNode;
        while(l1.next != null || l2.next != null || (flag && l1.next == null && l2.next == null)){
            if(l1.next == null){
                l1.next = new ListNode(0);
            }
            if(l2.next == null){
                l2.next = new ListNode(0);
            }
            l1 = l1.next;
            l2 = l2.next;
            currentSum = l1.val + l2.val;
            if(flag){
                currentSum += 1;
                flag = false;
            }
            if(currentSum >= 10){
                flag = true;
                currentSum -= 10;
            }
            ListNode node = new ListNode(currentSum);
            listNode.next = node;
            listNode = listNode.next;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(addTwoNumbers(null, null));
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}