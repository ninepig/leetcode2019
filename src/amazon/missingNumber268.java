package amazon;

/**
 * Created by yangw on 2019/4/14.
 */
public class missingNumber268 {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
            result ^= i;
        }
        return result ^= nums.length;
    }

    public int missingNumberGasse(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int gasse = nums.length * (nums.length + 1) / 2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return gasse - sum;
    }
}