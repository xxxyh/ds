package jianzhioffer;

public class Solution24 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }

    public ListNode reverseList2(ListNode head){
        ListNode pre = null, cur = head, next = null;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        print(l1);
        System.out.println();
        print(new Solution24().reverseList2(l1));
        System.out.println();
    }

    private static void print(ListNode listNode){
        if(listNode == null){
            return;
        }
        System.out.print(listNode.val + " ");
        print(listNode.next);
    }
}
