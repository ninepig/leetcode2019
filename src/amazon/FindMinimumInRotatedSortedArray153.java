package amazon;

/**
 * Created by yangw on 2019/4/3.
 */
public class FindMinimumInRotatedSortedArray153 {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int l = 0 , r = nums.length - 1;
        // Find the left and right of pivot.
        // 二分法，关键是找到pivot的两侧。
        while (l + 1 < r){
            int mid = l + (r - l)/2;
            if(nums[mid] < nums[r]){
                r = mid;
            }else {
                l = mid;
            }
        }
        return Math.min(nums[l],nums[r]);
    }
}
