package leetcode;

public class Solution083 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        while(p != null){
            if(p.next != null && p.next.val == p.val){
                p.next = p.next.next;
                continue;
            }
            p = p.next;
        }
        return head;
    }
}
