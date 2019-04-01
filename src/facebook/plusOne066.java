package facebook;

/**
 * Created by yangw on 2019/3/30.
 */
public class plusOne066 {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0){
            return digits;
        }
        for ( int i =  digits.length -1 ; i >= 0 ; i--){
            if(digits[i] < 9){
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}
