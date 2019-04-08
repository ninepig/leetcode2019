package facebook;

/**
 * Created by yangw on 2019/4/2.
 */
public class jumpGame055 {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return true;
        int postion = 0;
        int maxReach = 0;
        for(int index = 0 ; index < nums.length; index++){
            if(postion < index) break;
            maxReach = Math.max(maxReach, nums[index] + index);
            postion = maxReach;
            if(maxReach >= nums.length - 1) return true;
        }
        return false;
    }
}
