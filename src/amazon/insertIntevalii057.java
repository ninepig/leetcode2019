package amazon;

import java.util.ArrayList;
import java.util.List;

public class insertIntevalii057 {
    class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        if(intervals == null || intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }
        int newStart = 0,newEnd = 0;
        int i = 0 ;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start){
            res.add(intervals.get(i));
            i++;
        }
        // Border Case
        if(i == intervals.size()){
            res.add(newInterval);
            return res;
        }

        // Find the start
        newStart = Math.min(intervals.get(i).start,newInterval.start);

        // Find the newEnd (merge if need)
        // you need draw a picture to demo this.
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end){
            newEnd = Math.max(intervals.get(i).end,newEnd);
            i++;
        }

        res.add(new Interval(newStart,newEnd));
        while (i < intervals.size()){
            res.add(intervals.get(i));
            i++;
        }

        return res;
    }
}
