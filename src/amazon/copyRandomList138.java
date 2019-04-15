package amazon;

import java.util.HashMap;

/**
 * Created by yangw on 2019/3/25.
 */

public class copyRandomList138 {
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}
        public Node(int val){
            this.val = val;
        }
        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        HashMap<Node, Node> map = new HashMap<>();
        Node dummy = new Node();
        Node pre = dummy;
        Node newHead = new Node();

        while(head != null){
            if(map.containsKey(head)){
                newHead = map.get(head);
            }else{
                newHead = new Node(head.val);
                map.put(head,newHead);
            }
            if(head.random != null){
                if(map.containsKey(head.random)){
                    newHead.random = map.get(head.random);
                }else{
                    newHead.random = new Node(head.random.val);
                    map.put(head.random,newHead.random);
                }
            }
            // 关键步骤 ，把新头赋值pre指针
            pre.next = newHead;
            pre = pre.next;
            head = head.next;
        }
        return dummy.next;
    }

    public Node copyRandomListNoHashMap(Node head) {
        Node iter = head, next;

        /*
        1 2 3 4===> 1 1'2 2'3 3'4 4'
         */
        while(iter != null){
            next =iter.next;

            // Copy it self to next Node
            Node copy = new Node(iter.val);
            iter.next = copy;
            copy.next = next;

            iter = next;
        }

        /*
        Copy random
         */
        iter = head;
        while(iter != null){
            if(iter.random != null){
                // why ?
                //iter.random.next will be the copy of iter.random.
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }

        /*
        restore the orignal list and extract the copy list
         */
        iter = head;
        Node dummy = new Node(0);
        Node copy, copyIter = dummy;

        while (iter!=null){
            next = iter.next.next;
            // Extract the copy
            copy = iter.next;
            copyIter.next = copy;
            copyIter = copy;

            // restore the orignal list
            iter.next = next;
            iter = next;
        }
        return dummy.next;
    }
}
