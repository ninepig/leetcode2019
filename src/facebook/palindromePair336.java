package facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangw on 2019/4/1.
 */
public class palindromePair336 {
    public List<List<Integer>> palindromePairs2(String[] words) {
        List<List<Integer>> ret = new ArrayList<>();
        if(words == null || words.length < 2) return ret;
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0 ; i< words.length ; i++){
            map.put(words[i],i);
        }
        for (int i = 0 ; i < words.length ;i++){
            for (int j = 0 ; j < words[i].length() ; j++){
                String str1 = words[i].substring(0,j);
                String str2 = words[i].substring(j);
                if(isPalindrome(str1))
            }
        }

    }

    public static boolean isPalindrome (String word){
        for(int i=0, j=word.length()-1; i<j; i++, j--){
            if(word.charAt(i) == word.charAt(j))
                continue;
            else
                return false;
        }
        return true;
    }

}
