package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum015 {
    /**
     * Sorting + two pointer approaching way to do this
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length - 2 ; i++){
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
                int l = i + 1 , r = nums.length - 1, sum = - nums[i];
                while (l < r){
                    if(nums[l] + nums[r] == sum){
                        res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                        while (l < r && nums[l] == nums[l+1]) l++;
                        while (l < r && nums[r] == nums[r-1]) r--;
                        l++;
                        r--;
                    }else if ( nums[l] + nums[r] < sum){
                        l++;
                    }else {
                        r--;
                    }
                }
            }
        }
        return res;
    }

    /**
     * 利用 排序以后 去重的方法来做，问题是会超时
     * 但是要学到这个方法! 如果来去重的写法
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSumBrutalForce(int[] nums) {
            if(nums == null || nums.length == 0) return new ArrayList();
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            for(int i = 0 ; i < nums.length ; i++){
                if(i!=0 && nums[i] == nums[i-1]) continue;
                for(int j = i + 1; j< nums.length ; j++){
                    if(j != i+1 && nums[j] == nums[j-1]) continue;
                    for(int k = j + 1 ; k< nums.length ; k++){
                        if(k != j+1 && nums[k] == nums[k-1]) continue;
                        if(nums[i] + nums[j] + nums[k] == 0){
                            res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                        }
                    }
                }
            }
            return res;

        }

    }


