package leetcode;

public class Solution092 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        int i;
        for(i = 1;i < left;i++){
            prev = prev.next;
        }
        prev.next = reverseK(prev.next, right - left);
        return dummy.next;
    }

    private ListNode reverseK(ListNode head, int k){
        if(k <= 0){
            return head;
        }
        ListNode dummy = head;
        ListNode prev = head;
        head = head.next;
        ListNode tmp = null;
        for(int i = 0;i < k;i++){
            tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        dummy.next = head;
        return prev;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l1.next = l2;
        ListNode head = new Solution092().reverseBetween(l1, 1, 2);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
