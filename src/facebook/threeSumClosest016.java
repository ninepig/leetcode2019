package facebook;

import java.util.Arrays;

/**
 * Created by yangw on 2019/3/29.
 */
public class threeSumClosest016 {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        int res = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        for (int i = 0 ; i < nums.length ; i++){
            int low = i + 1 , high = nums.length - 1;
            while (low < high){
                int sum = nums[i] + nums[low] + nums[high];
                if( sum > target){
                    high--;
                }else{
                    low++;
                }
                if(Math.abs(sum - target) < Math.abs(sum - res)){
                    res = sum;
                }
            }
        }
        return res;
    }
}
