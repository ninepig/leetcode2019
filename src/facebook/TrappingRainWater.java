package facebook;

/**
 * Created by yangw on 2019/3/25.
 */
public class TrappingRainWater {
    /*
    暴力法 记录每个可能性，全部加起来
    对于每一个可能，向左向右找到最大的，然后计算。
     */
    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }

        int res = 0;

        for(int i = 1 ; i < height.length - 1 ; i++){
            int maxLeft = 0 , maxRight = 0;
            for(int j = i ; j >= 0 ; j--){
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for(int k = i ; k < height.length ; k++){
                maxRight = Math.max(maxRight, height[k]);
            }
            res += Math.min(maxLeft, maxRight) - height[i];
        }

        return res;
    }
    /*
    双指针的方法， 如果最高的右侧比最高的左侧高，只要用左侧减去当前的高度即是可以累加的水滴高度
     */
    public int trapTwoPointer(int[] height) {
        if(height == null || height.length == 0) return 0;
        int res = 0,leftMax = 0 , rightMax = 0;
        int l = 0 , r = height.length - 1;
        while(l < r) {
            leftMax = Math.max(leftMax, height[l]);
            rightMax = Math.max(rightMax, height[r]);
            if (leftMax < rightMax) {
                res += leftMax - height[l];
                l++;
            } else {
                res += rightMax - height[r];
                r--;
            }
        }
        return res;
        }

}
