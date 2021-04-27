package leetcode;

public class Solution025 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k <=1 || head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pointer = dummy;
        while(pointer != null){
            //记录上一个子链表的结尾
            ListNode lastPointer = pointer;

            int i = 0;
            for(;i < k;i++){
                pointer = pointer.next;
                if(pointer == null){
                    break;
                }
            }

            if(i == k){//中途没有break，这个组满足k个了
                //下一个子链表的头
                ListNode nextPointer = pointer.next;
                ListNode reverseList = reverse(lastPointer.next, nextPointer);

                pointer = lastPointer.next;
                lastPointer.next = reverseList;
                pointer.next = nextPointer;
            }
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head, ListNode tail){
        if(head == null || head.next == null){
            return head;
        }

        ListNode prev = null, temp = null;
        while(head != null && head != tail){
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
