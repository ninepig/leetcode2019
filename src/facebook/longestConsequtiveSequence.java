package facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangw on 2019/3/31.
 */
public class longestConsequtiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Map<Integer,Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int num : nums){
            if(!map.containsKey(num)){
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);
                int sum = left + right + 1;
                map.put(num, sum);
                max = Math.max(sum,max);

                map.put(num - left , sum);
                map.put(num + right, sum);
            }else
                continue;
        }
        return max;
    }

}
