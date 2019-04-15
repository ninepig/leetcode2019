package amazon;

/**
 * Created by yangw on 2019/4/5.
 * 看到nlogn 肯定要想起merge sort啊！
 * 然后就是快慢指针找中间点
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = findMid(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (left!=null && right!=null){
            if(left.val < right.val){
                head.next = left;
                left = left.next;
            }else{
                head.next =right;
                right = right.next;
            }
            head = head.next;
        }
        if(left!=null)head.next = left;
        if(right!=null) head.next = right;
        return dummy.next;
    }

    private ListNode findMid(ListNode head) {
        if (head == null) return head;
        ListNode slow  = head, fast = head;
        while (fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
