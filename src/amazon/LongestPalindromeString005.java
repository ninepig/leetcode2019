package amazon;

/**
 * Created by yangw on 2019/3/23.
 */
public class LongestPalindromeString005 {
    int MaxLength;
    int Lo;
    public String longestPalindrome(String s) {
        if(s.length() < 2){
            return s;
        }
        for(int i = 0 ; i < s.length() -1 ; i++){
            extendPalindrome(s,i,i);
            extendPalindrome(s,i,i+1);
        }
        return s.substring(Lo,MaxLength);
    }
    private void extendPalindrome(String s, int l , int r){

        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        if(MaxLength < r-l-1) {
            Lo = l + 1;
            MaxLength = r - l - 1;
        }
    }
}
