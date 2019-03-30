package facebook;

import java.io.CharArrayReader;
import java.util.HashMap;

/**
 * Created by yangw on 2019/3/29.
 */
public class MinimumWindowSubString76 {
//    public String minWindow(String s, String t) {
//        if(t == null || t.length() == 0 || s == null || s.length() == 0){
//            return "";
//        }
//        HashMap<Character,Integer> map = new HashMap<>();
//        int left = 0 , right = 0 , head = 0 , len = Integer.MAX_VALUE;
//
//        for(char c : t.toCharArray()){
//            map.put(c,map.getOrDefault(c,0)+1);
//        }
//        // Maintains how many characters in map.
//        int count = map.size();
//
//        while(right < s.length()){
//            char rightPointer = s.charAt(right);
//            if(map.containsKey(rightPointer)){
//                map.put(rightPointer,map.get(rightPointer) - 1);
//                if(map.get(rightPointer) == 0) count--;
//            }
//            right++;
//
//            while (count == 0){
//                char leftPointer = s.charAt(left);
//                if(map.containsKey(leftPointer)){
//                    map.put(leftPointer,map.get(leftPointer)+1);
//                    if(map.get(leftPointer) > 0) count++;
//                }
//
//                if(right - left < len) {
//                    len = right - left;
//                    head = left;
//                }
//                left++;
//            }
//        }
//        if(len == Integer.MAX_VALUE){
//            return "";
//        }
//        return s.substring(head,head+len);
//    }

    public String minWindow(String s, String t){
        if(s == null || s.length() == 0 || t == null || t.length() == 0) return "";
        HashMap<Character, Integer> map =  new HashMap<>();
        int left = 0 , right = 0 , len = Integer.MAX_VALUE,  head = 0 ,count = 0;

        for (char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        count = map.size();

        while (right < s.length()) {
            char rightPoint = s.charAt(right);
            if (map.containsKey(rightPoint)) {
                map.put(rightPoint, map.get(rightPoint) - 1);
                if (map.get(rightPoint) == 0) {
                    count--;
                }
            }
            right++;
            while (count == 0) {
                char leftPoint = s.charAt(left);
                if (map.containsKey(leftPoint)) {
                    map.put(leftPoint, map.get(leftPoint) + 1);
                    if (map.get(leftPoint) > 0) count++;
                }
                if (len > right - left) {
                    len = right - left;
                    head = left;
                }
                left++;
            }
        }
        if(len == Integer.MAX_VALUE) return  "";
        return s.substring(head,head+len);
    }
}
