package leetcode;

public class Solution143 {
    public void reorderList(ListNode head) {
        contact(head, head);
    }

    private ListNode contact(ListNode node, ListNode prev){
        if(node == null){
            return prev;
        }
        prev = contact(node.next, prev);
        if(node == prev){
            node.next = null;
            return null;
        }
        if(prev == null){
            return null;
        }
        ListNode pNext = prev.next;
        prev.next = node;
        if(pNext == node){
            node.next = null;
            return null;
        }
        node.next = pNext;
        return pNext;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        new Solution143().reorderList(l1);
        while(l1 != null){
            System.out.println(l1.val);
            l1 = l1.next;
        }
    }
}
