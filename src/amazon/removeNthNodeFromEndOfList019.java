package amazon;

/**
 * Created by yangw on 2019/3/29.
 */
public class removeNthNodeFromEndOfList019 {
    public ListNode removeNthFromEnd(ListNode head, int n){
        if(head == null) return head;


        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        for(int i = 0 ; i < n ; i++){
            fast = fast.next;
        }

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return dummy.next;
    }
}
