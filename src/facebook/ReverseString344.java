package facebook;

/**
 * Created by yangw on 2019/3/25.
 */
public class ReverseString344 {
    public String reverseString(String s) {
        if(s==null||s.length()==0){
            return "";
        }

        char[] stringArray = s.toCharArray();
        int l = 0;
        int r = s.length()-1;

        while (l<r){
            char temp = stringArray[l];
            stringArray[l] = stringArray[r];
            stringArray[r]= temp;
            l++;
            r--;
        }

        return new String(stringArray);
    }
}
