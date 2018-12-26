package sorting;

import java.util.PriorityQueue;
/**
 *leetcode 703
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 */

/**
 * Created by yangw on 2018/12/23.
 */
public class kthLargestNumberInstream {
    PriorityQueue<Integer> pq;
    int K ;
    public kthLargestNumberInstream(int k, int[] nums) {
        pq = new PriorityQueue<>(k);
        this.K = k;
        for(int num : nums){
            add(num);
        }
    }

    public int add(int val) {
        if(pq.size()<K){
            pq.offer(val);
        }else if (pq.peek() < val){
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }
}
