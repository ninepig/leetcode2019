package math;

/**
 * leetcode 264
 * https://leetcode.com/problems/ugly-number-ii/
 * https://leetcode.com/problems/ugly-number-ii/discuss/69362/O(n)-Java-solution
 * 利用数组index 相加
 */
public class uglyNumber2 {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int factor1 = 2 , factor2 = 3, factor3 = 5;
        int index1 = 0, index2 = 0 , index3 = 0;
        for(int i = 1 ; i < n ; i++){
            int min = Math.min(Math.min(factor1,factor2),factor3);
            ugly[i] = min;
            if(factor1 == min){
                factor1 = ugly[++index1]*2;
            }
            if (factor2 == min){
                factor2 = ugly[++index2]*3;
            }
            if(factor3 == min){
                factor3 = ugly[++index3]*5;
            }
        }

        return ugly[n-1];
    }
}
