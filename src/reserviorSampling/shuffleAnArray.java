package reserviorSampling;

import java.util.Random;

public class shuffleAnArray {
    private int[] nums;
    private Random random;
    public shuffleAnArray(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if(nums == null) return null;
        int[] a = nums.clone();
        for(int j = 1 ; j < a.length ; j++){
            int i = random.nextInt(j+1);
            swap(a,i,j);
        }
        return a;
    }

    private void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
