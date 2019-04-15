package amazon;

/**
 * Created by yangw on 2019/4/3.
 */
public class searchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l + 1 < r){
            int mid = l + (r - l )/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) r = mid;
            else l = mid;
        }
        if(nums[l]  >= target) return l;
        else if (nums[r] >= target) return r;
        else return r+1;
    }

}
