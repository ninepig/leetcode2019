package amazon;

/**
 * Created by yangw on 2019/4/12.
 */
public class maxProductSubArray152 {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0){
            return  0;
        }
        int preMax = nums[0] , preMin = nums[0];
        int min = 0 , max = 0;
        int res = nums[0];

        for (int i = 1 ; i < nums.length ; i++){
            max = Math.max(Math.max(preMax*nums[i], preMin*nums[i]),nums[i]);
            min = Math.min(Math.min(preMin*nums[i], preMax*nums[i]),nums[i]);
            res = Math.max(max,res);
            preMax = max;
            preMin = min;
        }
        return res;
    }
}
