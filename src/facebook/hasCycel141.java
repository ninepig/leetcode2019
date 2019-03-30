package facebook;

/**
 * Created by yangw on 2019/3/26.
 */
public class hasCycel141 {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode walker = head, runner = head;
        while(runner.next!=null && runner.next.next!=null){
            runner = runner.next.next;
            walker = walker.next;
            if(walker == runner) return true;
        }
        return false;
    }
}
