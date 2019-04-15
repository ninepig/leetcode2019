package amazon;

/**
 * Created by yangw on 2019/3/25.
 */
public class reverseLinkedList206 {
    public addTwoNumber002.ListNode reverseList(addTwoNumber002.ListNode head) {
                if(head == null) return head;
                addTwoNumber002.ListNode pre = null;
                addTwoNumber002.ListNode cur = head;
                while(cur!=null){
                    addTwoNumber002.ListNode temp = cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = temp;
                }
                return  pre;
    }
}