package amazon;

/**
 * Created by yangw on 2019/4/14.
 */
public class RotateArray189 {
    public void rotate(int[] arr , int k){
        if(arr == null || arr.length == 0) return;

        if(arr.length < k ){
            k = k % arr.length;
        }
        int size = arr.length;
        swap(arr,0,size - 1 - k);
        swap(arr,size - k ,arr.length - 1);
        swap(arr,0, arr.length - 1);

    }
    public void swap(int[] nums,int l,int r){
        while(l<r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}
