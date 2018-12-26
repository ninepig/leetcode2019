package string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * leetcode 179
 * 其实就是利用 compare函数来重新排列字符串数组 做过一次不会忘！
 * Created by yangw on 2018/12/25.
 */
public class largestNumber {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) return "0";
        String[] temp = new String[nums.length];
        for(int i = 0 ; i < nums.length; i++){
            temp[i] = nums[i] + "";
        }
        Comparator<String> comp = new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                String st1 = s1+s2;
                String st2 = s2+s1;
                return st2.compareTo(st1);
            }
        };
        Arrays.sort(temp,comp);
        if(temp[0].charAt(0) == '0')
            return "0";
        StringBuilder sb = new StringBuilder();
        for(String s : temp){
            sb.append(s);
        }
        return sb.toString();

    }
}
