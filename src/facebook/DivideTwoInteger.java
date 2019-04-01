package facebook;

/**
 * Created by yangw on 2019/3/30.
 */
public class DivideTwoInteger {

    public int divide(int dividend, int divisor) {
        int sign = 1;
        if(dividend == 0) return 0;
        if(dividend > 0 && divisor < 0) sign = -1;
        if(dividend < 0 && divisor > 0) sign = -1;

        long dEnd = Math.abs((long) dividend) ;
        long dSor = Math.abs((long) divisor);

        long ans = getDivisor(dEnd,dSor);

        if(ans > Integer.MAX_VALUE){
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }else {
            return sign * (int) ans;
        }
    }

    private long getDivisor(long dEnd, long dSor) {
            if (dEnd < dSor){
                return 0;
            }
            long sum = dSor;
            long mult = 1;
            while ((sum + sum) < dEnd){
                sum += sum;
                mult += mult;
            }
            return mult + getDivisor(dEnd - sum, dSor);
    }


}
