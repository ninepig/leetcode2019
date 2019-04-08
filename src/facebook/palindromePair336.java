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
            for (int j = 0 ; j <= words[i].length() ; j++){
                String str1 = words[i].substring(0,j);
                String str2 = words[i].substring(j);
                if(isPalindrome(str1)){
                    // abcde --> abcd looking for e. if we have e eabcde. it will be palindrome.
                    String str2rvs = new StringBuilder(str2).reverse().toString();
                    if(map.containsKey(str2rvs) && map.get(str2rvs) != i){
                        List<Integer> list = new ArrayList<>();
                        list.add(map.get(str2rvs));
                        list.add(i);
                        ret.add(list);
                    }
                }
                if(isPalindrome(str2)){
                    String str1rvs = new StringBuilder(str1).reverse().toString();
                    // Str2.length() != 0 use to avoid duplicate
                    if(map.containsKey(str1rvs) && map.get(str1rvs) != i && str2.length() != 0){
                        List<Integer> list = new ArrayList<>();
                        list.add(map.get(str1rvs));
                        list.add(i);
                        ret.add(list);
                    }
                }
            }
        }
        return ret;
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

    public static void main(String ... args){
        String abc = "0123456789";
        System.out.println(abc.substring(0,10));
    }
}
