package amazon;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by yangw on 2019/4/12.
 */
public class largestNumber179 {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        String[] temp = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i] + "";
        }

        Arrays.sort(temp, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String str1 = o1 + o2;
                String str2 = o2 + o1;
                return str2.compareTo(str1);
            }
        });
        if (temp[0].charAt(0) == 0) return "0";
        StringBuilder sb = new StringBuilder();
        for (String t : temp) {
            sb.append(t);
        }
        return sb.toString();
    }
}
