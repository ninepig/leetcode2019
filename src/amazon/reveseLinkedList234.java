package amazon;

/**
 * Created by yangw on 2019/4/2.
 */
public class reveseLinkedList234 {
    public boolean isPalindrome(ListNode head) {
        //edge condition
        if(head==null){
            return true;
        }
        if(head!=null&&head.next==null){
            return true;
        }
        ListNode slow =head;
        ListNode fast = head;
        //find the middle point
        while (fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //if fast is not null, it means it is odd number,
        if(fast!=null){
            slow =slow.next;
        }
        //reverse the right part of list
        ListNode newMid = reverse(slow);

        //pointer fast back to head node;
        fast = head;

        while (newMid!=null){
            if(newMid.val != fast.val){
                return false;
            }
            newMid =newMid.next;
            fast = fast.next;
        }

        return true;

    }

    private ListNode reverse(ListNode slow) {
        ListNode pre = null;
        while (slow != null){
            ListNode temp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = temp;
        }
        return pre;
    }
}
