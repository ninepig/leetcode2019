package string;

import java.util.HashSet;

/**
 * Leetcode 3
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 维护两个指针来做 l and r
 * 右侧的指针往右移动，不断加入set之中，set无法加入，表示已经出现重复的了，然后左侧的向右移动，类似sliding windows
 * Created by yangw on 2018/12/25.
 */
public class lengthOfLongestSubString {
    public int lengthOfLongestSubstring(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
//        HashSet<Character> set = new HashSet<>();
//        int i = 0, j = 0;
//        int result = 0;
//        while(j<s.length()){
//            if(!set.contains(s.charAt(j))){
//                set.add(s.charAt(j));
//                j++;
//                result = Math.max(result,set.size());
//            }else{
//                set.remove(s.charAt(i));
//                i++;
//            }
//        }
//        return result;
        HashSet<Character> set = new HashSet<>();
        int i = 0 , j = 0 ,max = 0;
        while(j < s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                max = Math.max(max,set.size());
            }else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }
}
