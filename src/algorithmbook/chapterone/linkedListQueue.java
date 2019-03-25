package algorithmbook.chapterone;

/**
 * Created by yangw on 2019/3/19.
 * queue的基本实现，需要有第一个节点 以及最后一个节点的reference
 */
public class linkedListQueue<Item> {
    private Node first;
    private Node last;
    private int N;

    public boolean isEmpty(){
        return N == 0;
    }
    public int size(){
        return N;
    }
    public void enqueue(Item item){
        Node oldLast = last ;
        last = new Node();
        last.item = (algorithmbook.chapterone.Item) item;
        last.next = null;
        if(isEmpty()) first = last;
        else oldLast.next = last;
        N++;
    }
    public Item dequeue(){
        Item item = (Item) first.item;
        first = first.next;
        if(isEmpty()) last = null;
        N--;
        return item;
    }
}
