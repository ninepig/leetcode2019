package amazon;

/**
 * Created by yangw on 2019/3/23.
 */
public class reverseInteger007 {
    public int reverse(int x) {
        if(x == 0) return 0;
        int a = Math.abs(x);
        int result = 0;
        while(a > 0){
            // Test overflow condition.
            if(result > (Integer.MAX_VALUE - a%10)/10){
                return 0;
            }
            result = result * 10 +  a%10;
            a = a / 10;
        }
        return x > 0 ? result : -result;
    }
}
