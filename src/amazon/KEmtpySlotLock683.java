package amazon;

import java.util.TreeSet;

/**
 * Created by yangw on 2019/3/28.
 */
public class KEmtpySlotLock683 {
    public int kEmptySlots(int[] flowers, int k){
        int n = flowers.length;
        if(n == 1 && k == 0) return 1;
        TreeSet<Integer> sort = new TreeSet<>();
        for(int i = 0 ; i < n ; i++){
            sort.add(flowers[i]);
            Integer min = sort.lower(flowers[i]);
            Integer max = sort.higher(flowers[i]);
            if(min != null && flowers[i] - min == k + 1) return i+1; // in which day
            if(max != null && max - flowers[i] == k +1 ) return i+1;
        }
        return -1;
    }
}
