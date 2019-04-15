package amazon;

import java.util.HashMap;

/**
 * Created by yangw on 2019/3/23.
 */
public class LRUcache146 {
    class Node{
        int key;
        int value;
        Node pre;
        Node next;
        public Node (int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    int capacity;
    Node head, tail;
    int count;
    HashMap<Integer, Node> map;
    public LRUcache146(int capacity ){
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        head.pre = null;
        tail.pre = head;
        tail.next = null;
        //忘记加了
        count = 0;
    }

    public void addToHead(Node node){
        // 先连接无关的 ， 在连接相关的
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }
    public void deleteNode(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void putNode(int key, int value){
        // 如果存在了，就更新value， 然后放到头部
        if(map.get(key) != null){
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        }else {
            Node node = new Node(key,value);
            map.put(key,node);
            if(count < capacity){
                count++;
                addToHead(node);
            }else {
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
                addToHead(node);
            }
        }
    }

    public int getNode(int key){
        if(map.get(key) != null){
            Node node = map.get(key);
            int result = node.value;
            deleteNode(node);
            addToHead(node);
            return result;
        }
        return -1;
    }

}
