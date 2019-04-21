package amazon;

/**
 * Created by yangw on 2019/4/15.
 */
public class RotateList061 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0){
            return head;
        }
        int length = 0;
        while(head != null){
            length++;
            head = head.next;
        }
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0 ; i < k % length ;i++){
            fast = fast.next;
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }

}
