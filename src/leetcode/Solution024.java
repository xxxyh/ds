package leetcode;

public class Solution024 {
    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode temp = hair;
        while(temp.next != null && temp.next.next != null){
            ListNode l1 = temp.next;
            ListNode l2 = temp.next.next;
            l1.next = l2.next;
            l2.next = l1;
            temp.next = l2;
            temp = temp.next.next;
        }
        return hair.next;
    }
    private void show(ListNode node){
        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        new Solution024().swapPairs(l1);
    }
}
