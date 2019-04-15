package amazon;

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

    public int jump056(int[] A) {
        int times = 0;
        int reached = 0;
        int max = 0;
        for(int i=0;i< A.length;i++){
            if(reached < i){
                times++;
                reached = max;
            }
            max = Math.max(max,i+A[i]);
        }
        return times;
    }

}
