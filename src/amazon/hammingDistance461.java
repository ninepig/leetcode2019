package amazon;

/**
 * Created by yangw on 2019/4/12.
 */
public class hammingDistance461 {
    public int hammingDistance(int x, int y) {
        int target = x^y;
        int res = 0;
        for(int i = 0 ; i < 32; i++){
            if(((target>>i) & 1) == 1 )res++;
        }
        return res;
    }

}
