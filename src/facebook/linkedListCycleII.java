package facebook;

import java.util.List;

/**
 * Created by yangw on 2019/4/5.
 */
public class linkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) break;
        }

        if (fast.next == null || fast.next.next == null) return null;
        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
