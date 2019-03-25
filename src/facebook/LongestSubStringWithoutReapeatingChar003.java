package facebook;

import java.util.HashSet;

/**
 * Created by yangw on 2019/3/21.
 */
public class LongestSubStringWithoutReapeatingChar003 {
    public int lengthOfLongestSubstring(String s){
        if(s == null || s.length() == 0) return 0;
        HashSet<Character> set  = new HashSet<>();
        int l = 0 , r = 0;
        int max = 0;
        // 双指针移动的一般都用while 循环
        while(r < s.length()){
            if(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }else{
                set.add(s.charAt(r));
                r++;
                max = Math.max(max,set.size());
            }
        }
        return max;
    }
}
