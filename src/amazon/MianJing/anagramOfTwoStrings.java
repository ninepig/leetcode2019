package amazon.MianJing;

/**
 * Created by yangw on 2019/4/28.
 */
public class anagramOfTwoStrings {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] alphbatS = new int[26];
        int[] alphbatT = new int[26];

        for (int i = 0; i < s.length(); i++)
        {
            alphbatS[s.charAt(i) - 'a']++;
            alphbatT[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++)
        {
            if (alphbatS[i] != alphbatT[i]) return false;
        }
        return true;
    }
}
