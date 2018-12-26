package string;

/**
 * Leetcode 5
 * medium
 * 向两边扩展,可能是缝隙，可能不是缝隙
 * https://leetcode.com/problems/longest-palindromic-substring/
 * Created by yangw on 2018/12/25.
 */
public class longestPalindromeString {
    public String longestPalindrome(String s) {
        if(s==null||s.length()==0){
            return s;
        }
        int max = 0;
        String maxString = "";

        for(int i = 0 ; i<2* s.length()-1;i++){
            int left = i/2;
            int right = i/2;
            if(i%2==1){
                right +=1;
            }
            String temp = getLongestPalindrome(left,right,s);
            if(temp.length()>max){
                max = temp.length();
                maxString = temp;
            }
        }

        return maxString;
    }

    public String getLongestPalindrome(int left,int right,String s){

        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }

        return s.substring(left+1,right);
    }
}
