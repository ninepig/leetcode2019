package amazon;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangw on 2019/4/13.
 */
public class DegreeOfAnArray697 {
    public int findShortestSubArray(int[] nums) {
        if( nums == null || nums.length == 0)return 0;
        Map<Integer, int[]> map = new HashMap<>();

        for (int i = 0 ; i < nums.length ; i++){
            if (!map.containsKey(nums[i])){
                map.put(nums[i], new int[]{1,i,i});
            }else {
                int[] temp = map.get(nums[i]);
                temp[0]++;
                temp[2] = i;
            }
        }
        int degree = Integer.MIN_VALUE, Res = Integer.MAX_VALUE;

        for (int[] value : map.values()){
            if(value[0] > degree){
                degree = value[0];
                Res = value[2] - value[1] + 1;
            }else if(value[0] == degree){
                Res = Math.min((value[2] - value[1] + 1),Res);
            }
        }
        return Res;
    }
}
