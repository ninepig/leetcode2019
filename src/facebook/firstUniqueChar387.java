package facebook;

/**
 * Created by yangw on 2019/4/5.
 */
public class firstUniqueChar387 {
    public int firstUniqChar(String s) {
        if(s==null||s.length()==0){
            return -1;
        }
        int[] helper = new int[26];

        for (char a :s.toCharArray()){
            helper[a-'a']++;
        }
        for (int i = 0 ; i<s.length();i++){
            char thisChar = s.charAt(i);
            if(helper[thisChar-'a']==1){
                return i;
            }
        }
        return -1;
    }
}
