package amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangw on 2019/4/12.
 */
public class findAllDuplicatedInArray442 {
    // when find a number i, flip the number at position i-1 to negative.
    // if the number at position i-1 is already negative, i is the number that occurs twice.
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();

        if (nums == null || nums.length == 0) return res;

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                res.add(index + 1);
            }
            nums[index] = -nums[index];
        }

        return res;
    }
}
