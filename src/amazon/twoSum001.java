package amazon;

import java.util.HashMap;

public class twoSum001 {
    /**
     * Hashmap version
     * using hashmap's key to store the array's value , if we have two key's sum of target.
     * value as the index of array.
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{};
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                l = map.get(target - nums[i]);
                r = i;
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{l, r};
    }

    public int[] twoSumBrutalForce(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{};
        for(int i = 0 ; i < nums.length ; i++){
            for(int j = i + 1 ; j < nums.length ; j++ ){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }
}