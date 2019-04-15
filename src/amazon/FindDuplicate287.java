package facebook;

public class FindDuplicate287 {
    // nLogN version
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int l = 0 , r = nums.length - 1;
        while(l < r){
            int mid = l + (r - l) / 2;
            int count = 0;
            for(int num : nums){
                if(num <= mid){
                    count++;
                }
            }
            if(count <= mid) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
