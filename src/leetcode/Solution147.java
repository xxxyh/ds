package leetcode;

public class Solution147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode r = new ListNode(0);
        r.next = head;
        ListNode p = head;
        ListNode r1 = r;
        while(p != null){
            ListNode q = r.next;
            ListNode r2 = r;
            while(q != p && q.val < p.val){
                q = q.next;
                r2 = r2.next;
            }
            if(q == p){
                r1 = r1.next;
                p = p.next;
                continue;
            }
            r2.next = p;
            r1.next = p.next;
            p.next = q;
            p = r1.next;
        }
        return r.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        new Solution147().insertionSortList(l1);
    }
}
