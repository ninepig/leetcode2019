package facebook;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by yangw on 2019/4/3.
 */
public class test {
    public static void main(String ... args){
        PriorityQueue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());
        min.offer(1);
        min.offer(2);
        min.offer(3);

        System.out.println(min.poll());
    }
}
