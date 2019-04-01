package facebook;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yangw on 2019/3/31.
 */
public class wordLadder127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Set<String> reach = new HashSet<>();

        reach.add(beginWord);
        int ladder = 1;

        while (!reach.contains(endWord)){
            Set<String> toAdd = new HashSet<>();
            for (String str : reach){
                for (int i = 0 ; i < str.length();i++){
                    char[] charArray = str.toCharArray();
                    for (char ch = 'a' ; ch <= 'z' ; ch++){
                        charArray[i] = ch;
                        String newStr = new String(charArray);
                        if(dict.contains(newStr)){
                            toAdd.add(newStr);
                            dict.remove(newStr);
                        }
                    }
                }
            }
            ladder++;
            if(toAdd.size() == 0){
                return 0;
            }
            reach = toAdd;
        }

        return ladder;
    }

}
