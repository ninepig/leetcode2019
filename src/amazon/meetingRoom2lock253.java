package amazon;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by yangw on 2019/3/29.
 */
public class meetingRoom2lock253 {
     class Interval {
          int start;
          int end;
         Interval() { start = 0; end = 0; }
         Interval(int s, int e) { start = s; end = e; }
    }
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return  0;
        Arrays.sort(intervals,(a,b)->a.start - b.start);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(Interval i : intervals){
            if(!pq.isEmpty() && pq.peek() < i.start){
                pq.poll();
            }
            pq.offer(i.end);
        }
        return pq.size();
     }
}
