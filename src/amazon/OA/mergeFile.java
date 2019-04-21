package amazon.OA;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by yangw on 2019/4/20.
 */
public class mergeFile {

        // Function to find minimum computation
        static int minComputation(int size, int files[])
        {

            // create a min heap
            PriorityQueue<Integer> pq
                    = new PriorityQueue<>();

            for (int i = 0; i < size; i++) {

                // add sizes to priorityQueue
                pq.add(files[i]);
            }

            // variable to count total computations
            int count = 0;

            while (pq.size() > 1) {

                // pop two smallest size element
                // from the min heap
                int temp = pq.poll() + pq.poll();

                // add the current computations
                // with the previous one's
                count += temp;
                System.out.println(temp);
                System.out.println(count);
                // add new combined file size
                // to priority queue or min heap
                pq.add(temp);
            }

            return count;
        }

    static int minComputation(int size, List<Integer> files)
    {

        // create a min heap
        PriorityQueue<Integer> pq
                = new PriorityQueue<>();

        for (int i = 0; i < size; i++) {

            // add sizes to priorityQueue
            pq.add(files.get(i));
        }

        // variable to count total computations
        int count = 0;

        while (pq.size() > 1) {

            // pop two smallest size element
            // from the min heap
            int temp = pq.poll() + pq.poll();

            // add the current computations
            // with the previous one's
            count += temp;
            System.out.println(temp);
            System.out.println(count);
            // add new combined file size
            // to priority queue or min heap
            pq.add(temp);
        }

        return count;
    }

        public static void main(String[] args)
        {

            // no of files
            int size = 6;

            // 6 files with their sizes
//            int files[] = new int[] { 2, 3, 4, 5, 6, 7 };
                        int files[] = new int[] { 2, 1, 10, 5, 35, 89 };
            List<Integer> fs = Arrays.asList(2,1,10,5,35,89);
            // total no of computations
            // do be done final answer
            System.out.println("Minimum Computations = "
                    + minComputation(size, fs));
        }

}
