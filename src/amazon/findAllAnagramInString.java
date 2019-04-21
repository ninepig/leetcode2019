package amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yangw on 2019/4/16.
 */
public class findAllAnagramInString {
    public List<Integer> findAnagrams(String s, String t) {
        List<Integer> res= new ArrayList<>();

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()){
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        int l = 0 , r = 0;
        int length = s.length();
        int count = map.size();

        while (r < length){
            char endChar = s.charAt(r);
            if (map.containsKey(endChar)){
                map.put(endChar,map.get(endChar) - 1);
                if(map.get(endChar) == 0){
                    count--;
                }
            }
            r++;

            while (count == 0){
                char beginChar = s.charAt(l);
                if(map.containsKey(beginChar)){
                    map.put(beginChar,map.get(beginChar)+1);
                    if(map.get(beginChar)>0){
                        count++;
                    }
                }
                if(r - l == t.length()){
                    res.add(l);
                }
                l++;
            }
        }
        return res;
    }

}
