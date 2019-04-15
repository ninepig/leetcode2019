package amazon;

import java.util.PriorityQueue;

/**
 * Created by yangw on 2019/3/23.
 */
public class MergeKList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode mergeKLists(ListNode[] lists) {
            ListNode dummy = new ListNode(0);
            ListNode head = dummy;

            if(lists == null || lists.length == 0) return head;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length,(a,b) -> a.val - b.val);

        for (ListNode node : lists){
            if(node != null){
                pq.offer(node);
            }
        }

        while (!pq.isEmpty()){
            ListNode temp = pq.poll();
            head.next = temp;
            if(temp!=null){
                pq.offer(temp.next);
            }
            head = head.next;
        }


        return dummy.next;

    }
}
