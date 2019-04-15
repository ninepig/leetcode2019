package facebook;

public class reorderList {
    public void reorderList(ListNode head) {
        if(head == null) return ;

        ListNode mid = findMid(head);

        ListNode midHead = reverse(mid.next);

        mid.next = null;

        merge(head,midHead);

    }

    private void merge(ListNode head, ListNode mid) {
        ListNode dummy = new ListNode(0);
        int index = 0;
        while (head != null && mid != null){
            if(index % 2 == 0){
                dummy.next = head;
                head = head.next;
            }else{
                dummy.next = mid;
                mid  = mid.next;
            }
            index++;
            dummy = dummy.next;
        }
        if(head!=null){
            dummy.next = head;
        }
        if(mid !=null){
            dummy.next = mid;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }


    private ListNode findMid(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
}
