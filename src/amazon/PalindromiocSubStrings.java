package amazon;

/**
 * Created by yangw on 2019/4/15.
 * similar to leetcode 5
 */
public class PalindromiocSubStrings {
    int count = 0;
    public int countSubstrings(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        for(int i = 0;i<s.length();i++){
            //odd length
            countPalidrom(s,i,i);
            //even length
            countPalidrom(s,i,i+1);
        }
        return count;
    }

    private void countPalidrom(String s, int i, int j) {
        while (i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j)){
            count++;
            i--;
            j++;
        }
    }
}
