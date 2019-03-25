package facebook;

import java.util.PriorityQueue;

/**
 * Created by yangw on 2019/3/22.
 */
public class findMedianSortedArrays004 {
    /**
     * heap version
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArraysBrutalForce(int[] nums1, int[] nums2) {
        boolean even = (nums1.length + nums2.length)%2 == 1 ? false : true;

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int a : nums1){
            heap.offer(a);
        }
        for (int b : nums2){
            heap.offer(b);
        }
        if(!even){
            for(int i = 0 ; i <(nums1.length + nums2.length)/2;i++ ){
                heap.poll();
            }
            return heap.poll();
        }else{
            for(int i = 0 ; i <(nums1.length + nums2.length)/2 - 1;i++ ){
                heap.poll();
            }
            int first = heap.poll();
            int second = heap.poll();
            System.out.println("fisrt is" + first +"sec" + second);
            return (first+second)/2.0;
        }
    }

    public static void main(String... args){
        int[] num1 = {1,2,3,4};
        int[] num2 = {1,2,3,4};
//        System.out.println(findMedianSortedArrays(num1,num2));

    }

    /**
     * https://github.com/mission-peace/interview/blob/master/src/com/interview/binarysearch/MedianOfTwoSortedArrayOfDifferentLength.java
     * @param input1
     * @param input2
     * @return
     */
    public double findMedianSortedArrays(int[] input1 , int[] input2){

        if(input1.length > input2.length){
            return findMedianSortedArrays(input2,input1);
        }

        int x = input1.length;
        int y = input2.length;

        int low = 0;
        int high = x;

        while(low <= high){
            int partitionX = (low + high)/2;
            int partitionY = (x + y +1 )/2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : input1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : input2[partitionY];

            // target
            if(maxLeftX <= minRightY && maxLeftY <= minRightX){

                if((x + y )% 2 == 0){
                    return ((double)Math.max(maxLeftX,maxLeftY) + Math.min(minRightX,minRightY))/2;
                }else {
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            }else if(maxLeftX > minRightY){
                // X 的partition 太靠右了
                high = partitionX-1;
            }else{
                low = partitionX +1 ;
            }
        }
        throw  new IllegalArgumentException();
    }


}
