package facebook;

import java.util.Stack;

/**
 * Created by yangw on 2019/4/10.
 */
public class addTwoNumber445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1!=null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2!=null){
            s2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0 ;
        ListNode list = new ListNode(0);

        while (!s1.isEmpty()||!s2.isEmpty()){
            if(!s1.isEmpty()) carry += s1.pop();
            if(!s2.isEmpty()) carry += s2.pop();
            // 关键在于这里，当前相加的节点，先把余数加上
            list.val = carry % 10;
            // 有一个之前的头部节点
            ListNode head  = new ListNode(carry/10);
            // 头节点的下一个节点 ，设为当前的节点
            head.next = list;
            // 循环下去
            list = head;
            carry = carry/10;

        }
        return list.val == 0 ? list.next : list;
    }
}
