package jianzhioffer;

public class Solution18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = head;
        while(q != null){
            if(q.val == val){
                p.next = q.next;
                break;
            }
            q = q.next;
            p = p.next;
        }
        return dummy.next;
    }
}
