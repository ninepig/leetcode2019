package amazon;

/**
 * Created by yangw on 2019/4/14.
 */
public class sqrt69 {
    public int sqrt(int x){
        if(x == 0) return 0;

        long l = 0;
        long r = (long) x;

        while (l < r){
            long mid  = l + (r - l)/2;
            if(mid * mid == x){
                return (int) mid;
            }else if(mid * mid < x){
                l = mid;
            }else{
                r = mid;
            }
        }

        if(r*r <= x)return(int)r;
        else return (int)l;

    }
}
