package amazon;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yangw on 2019/4/4.
 */
public class cloneGraph {

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};

    public class Solution {
        public Node cloneGraph(Node node) {
            if(node == null) return node;
            // Fake constructor
            Node head = new Node(node.val,null);
            HashMap<Integer,Node> map = new HashMap();
            map.put(head.val,head);

            LinkedList<Node> queue = new LinkedList();
            queue.add(head);
            while(!queue.isEmpty()){
                Node curr = queue.pop();
                for(Node n : curr.neighbors){
                    if(!map.containsKey(n.val)){
                        // copy neighbors.
//                        map.put(n.val, new Node(n.val));
                        // add neighbour to queue.
                        queue.add(n);
                    }
                    // assign neigbors to new node's neighbors
                    map.get(curr.val).neighbors.add(map.get(n.val));
                }
            }
            return head;
        }
    }
}
