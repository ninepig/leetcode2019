package amazon;

import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/**
 * Created by yangw on 2019/4/28.
 */
public class zigzagIterator281 {

    private Queue<Iterator> que;
    private List<Integer> v1;
    private List<Integer> v2;

    // If it is a list . same thing, do a loop and put in to queue.
    public zigzagIterator281(List<Integer> v1, List<Integer> v2) {
//        que = new LinkedList<>();
//        this.v1 = v1;
//        this.v2 = v2;
//        if (!v1.isEmpty()) que.add(v1.iterator());
//        if (!v2.isEmpty()) que.add(v2.iterator());
    }

    public int next() {

        Iterator i = que.poll();
        int next = (Integer)i.next();

        if (i.hasNext()) que.add(i);

        return next;
    }

    public boolean hasNext() {
        return !que.isEmpty();
    }
}
