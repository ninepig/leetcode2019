package amazon;

/**
 * Created by yangw on 2019/4/4.
 */
public class houseRobbery198 {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0],nums[1]);

        int[] max = new int[nums.length];
        max[0] = nums[0];
        max[1] = Math.max(nums[0],nums[1]);
        for(int i = 2 ;  i < nums.length ; i++){
            max[i] = Math.max(max[i-1], max[i-2] + nums[i]);
        }

        return max[nums.length - 1];

    }
}
