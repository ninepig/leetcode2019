package amazon;

/**
 * Created by yangw on 2019/4/14.
 */
public class WiggleSort {
    public void wiggleSort(int[] nums){
        if(nums == null || nums.length == 0){
            return;
        }
        // 很关键 num.length - 1
        for (int i = 0 ; i < nums.length - 1; i++){
            if(i % 2 == 0){
                if(nums[i] > nums[i+1]){
                    swap(nums,i,i+1);
                }
            }
            else {
                if(nums[i] < nums[i+1]){
                    swap(nums, i , i+1);
                }
            }
        }

    }

    private void swap(int[] nums, int i, int i1) {
    }
}
