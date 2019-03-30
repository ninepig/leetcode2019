package facebook;

/**
 * Created by yangw on 2019/3/29.
 */
public class myPow050 {
    public double myPow(double x, int n) {
        if(n == 0 ) return 1.0;
        if(n == 1) return x;
        if(n < 0 ){
            x = 1/x;
            n = -n;
        }
        if( n % 2 == 0){
            return myPow(x*x,n/2);
        }else {
            return  x*myPow(x*x,n/2);
        }
    }
}