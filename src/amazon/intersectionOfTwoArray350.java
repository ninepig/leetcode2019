package amazon;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by yangw on 2019/4/16.
 */
public class intersectionOfTwoArray350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> resList = new ArrayList<>();
        int i = 0 , j = 0;
        while (true){
            if(i >= nums1.length || j >= nums2.length){
                break;
            }
            if(nums1[i] == nums2[j]){
                resList.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else {
                i++;
            }
        }
        int[] res = new int[resList.size()];
        for (int k = 0 ; k < resList.size();k++){
            res[k] = resList.get(k);
        }
        return  res;
    }

}
