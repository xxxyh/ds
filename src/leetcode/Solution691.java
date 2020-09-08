package leetcode;

public class Solution691 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public static ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null || k <= 0){
            return null;
        }
        ListNode fast = head,slow = head;
        for(int i = 0;i < k;i++){
            if(fast != null){
                fast = fast.next;
            }else{
                return null;
            }
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
