package leetcode;

public class Solution142 {

    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                ListNode q = head;
                while(q != slow){
                    q = q.next;
                    slow = slow.next;
                }
                return q;
            }
        }
        return null;
    }
}
