package array;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yangw on 2018/12/25.
 */
public class fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0)return res;
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length - 3; i++){
            if(i == 0 || (i>0 && nums[i-1] == nums[i])){
                for(int j = i+1 ; j < nums.length -2 ;j++){
                    if(j == i+1 || nums[j-1] == nums[j]){
                        int left = j+1 , right = nums.length-1;
                        if(target == nums[left]+nums[right]+nums[i]+nums[j]){
                            res.add(Arrays.asList(nums[left],nums[right],nums[i],nums[j]));
                            while(left < right && nums[left] == nums[left+1]) left++;
                            while(left < right && nums[right] == nums[right-1]) right--;
                            right--;
                            left++;
                        }
                    }
                }
            }
        }
        return res;
    }
}
