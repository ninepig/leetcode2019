package amazon;

/**
 * Created by yangw on 2019/3/30.
 */

/**
 * *----------------------------
 *prev
 *tail   head
 *dummy   1    2    3   4    5
 *----------------------------
 *prev   head      tail
 *dummy   1    2    3   4    5
 *       cur
 *----------------------------
 * 每次让prev.next的元素插入到当前tail之后,这样tail不断前移,被挪动的元素头插入tail之后的链表
 *prev        tail head
 *dummy   2    3    1   4    5
 *       cur
 *----------------------------
 *prev   tail      head
 *dummy   3    2    1   4    5
 *       cur
 *----------------------------
 *                 prev
 *                 tail
 *                 head
 *dummy   3    2    1   4    5
 *----------------------------
 *                 prev  head     tail
 *dummy   3    2    1     4    5  null
 *----------------------------
 */

public class reverseInKgroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k < 2) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = dummy , pre = dummy , temp;
        int count = 0;
        while ( true) {
            count = k ;
            while (count > 0 && tail!=null){
                count -- ;
                tail = tail.next;
            }
            if (tail == null) break; // reach the end;

            head = pre.next; // For next cycle

            while (pre.next!=null){
                temp = pre.next;
                pre.next = temp.next;
                temp.next = tail.next;
                tail.next = temp;
            }
            tail = head;
            pre = head;
        }

        return dummy.next;
    }
}
