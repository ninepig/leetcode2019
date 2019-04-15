package amazon;

public class addTwoNumber002 {

       class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    /**
     * 最基本的dummy node 方法. 简便的写法。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode newHead = dummy;
        int carry = 0;
        while(l1 != null || l2 != null){
            int sum = 0 ;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            int digit = (sum + carry)%10;
            carry = (sum + carry)/10;
            newHead.next = new ListNode(digit);
            newHead = newHead.next;

        }

        if(carry != 0){
            newHead.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
