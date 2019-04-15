package amazon;

/**
 * Created by yangw on 2019/4/15.
 */
public class SortColors75 {
    public void sortColorsTwoPass(int[] nums) {
        int num1 = 0 , num2 = 0, num3 =0;

        for (int num : nums){
            if(num == 0){
                num1++;
            }else if(num2 == 0){
                num2++;
            }else {
                num3++;
            }
        }
        for (int i = 0 ; i < nums.length ;i++){
            if(i < num1){
                nums[i] = 0;
            }else if(i < num1 + num2){
                nums[i] = 1;
            }else {
                nums[i] = 2;
            }
        }

    }
    // 要画图做
    public void sortColorsOnePass(int[] nums){
        int p0 = 0 , p2 = nums.length - 1 , index = 0;

        while (index < p2){
            if(nums[index] == 0){
                nums[index] = nums[p0];
                nums[p0] = 0;
                p0++;
            }else if(nums[index] == 2){
                nums[index] = nums[p2];
                nums[p2] = 2;
                p2--;
                index--;
            }
            index++;
        }
    }

}
