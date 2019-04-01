package facebook;

import java.util.PriorityQueue;

/**
 * Created by yangw on 2019/3/31.
 */
public class kthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue(k);
        for (int num : nums){
            if(maxHeap.size() < k){
                maxHeap.offer(num);
            }else {
                if( num > maxHeap.peek()) {
                    maxHeap.poll();
                    maxHeap.offer(num);
                }
            }
        }
        return maxHeap.peek();
    }

    public  static  void main(String...args){
//        PriorityQueue<Integer> maxHeap = new PriorityQueue(5);
//        maxHeap.offer(1);
//        maxHeap.offer(3);
//        maxHeap.offer(4);
//        maxHeap.offer(5);
//        maxHeap.offer(2);
//        while (!maxHeap.isEmpty()){
//            System.out.println(maxHeap.peak());
//        }
        int[] a = new int[]{1,2,3,4,5};
        kthLargestElementInArray b =new kthLargestElementInArray();
        System.out.println(b.findKthLargest(a,5));
    }
}
