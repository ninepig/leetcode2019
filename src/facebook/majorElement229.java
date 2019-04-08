package facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangw on 2019/4/5.
 */
public class majorElement229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;

        int majorA = nums[0], majorB = nums[0];
        int countA = 0 , countB = 0;

        for (int num : nums){
            // 必须先判断第一个值，不能直接等于0， 这个上来就只有0，没有赋值，要不然就会跳过去了，不仔细发生的问题。
            if(num == majorA){
                countA++;
                continue;
            }
            if(num == majorB){
                countB++;
                continue;
            }
            if(countA == 0){
                countA++;
                majorA = num;
                continue;
            }
            if(countB == 0){
                countB++;
                majorB = num;
                continue;
            }
            countA--;
            countB--;
        }

        // We have two major elements at this time.
        countA=0;
        countB=0;

        for (int num:nums){
            if (num==majorA){
                countA++;
            }else if (num==majorB){
                countB++;
            }
        }


        if(countA > nums.length / 3) res.add(majorA);
        if(countB > nums.length / 3) res.add(majorB);

        return res;
    }

}
