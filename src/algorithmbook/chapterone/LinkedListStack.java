package algorithmbook.chapterone;

/**
 * Created by yangw on 2019/3/19.
 * 利用单向linked list 实现的栈
 */
public class LinkedListStack {
    private Node first;
    private int N;

    public boolean isEmpty(){ return first == null;}
    public int size() { return N;}

    public void push(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop(){
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }
}
