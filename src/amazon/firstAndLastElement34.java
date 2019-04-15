package amazon;

/**
 * Created by yangw on 2019/4/12.
 */
public class firstAndLastElement34 {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }

        int left = 0, right = nums.length -1;
        int firstIndex = -1, lastIndex = -1;

        while(left+1 < right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                right = mid;
            }else if(nums[mid] > target){
                right = mid;
            }else{
                left = mid;
            }
        }
        if(nums[left] == target){
            firstIndex = left;
        }else if(nums[right] == target){
            firstIndex = right;
        }

        left = 0;
        right = nums.length -1 ;
        while(left+1 < right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                left = mid;
            }else if(nums[mid] > target){
                right = mid;
            }else{
                left = mid;
            }
        }
        if(nums[right] == target){
            lastIndex = right;
        }else if(nums[left] == target){
            lastIndex = left;
        }

        return new int[]{firstIndex,lastIndex};
    }
}
