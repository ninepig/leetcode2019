package facebook;

import java.util.Stack;

/**
 * Created by yangw on 2019/3/31.
 */
public class reverseLinkedListII092 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return head;
        ListNode dummy  = new ListNode(0);
        dummy.next = head;
        ListNode preHead = dummy;

        // Move m - 1 step to get  the node before M
        for (int i = 1 ; i < m ; i++){
            preHead = preHead.next;
        }

        Stack<ListNode> stack = new Stack<>();

        ListNode preNode = preHead;
        ListNode mNode = preNode.next;

        int i = 0 ;
        while (m + i <= n){
            stack.push(mNode);
            mNode = mNode.next;
            i++;
        }

        ListNode postNode = mNode;
        ListNode resultNode = stack.pop();
        ListNode tempNode = resultNode;

        while (!stack.isEmpty()){
            tempNode.next = stack.pop();
            tempNode = tempNode.next;
        }

        preNode.next = resultNode;
        tempNode.next = postNode;

        return dummy.next;
    }
}
