package amazon;

/**
 * Created by yangw on 2019/4/15.
 */
public class permutationSequence60 {
    public String getPermutation(int n, int k) {
        char[] nums = new char[]{'1','2','3','4','5','6','7',
        '8','9'};
        StringBuilder sb = new StringBuilder();
        for (char num : nums){
            sb.append(num);
        }
        String res = "";
        while (k > 0 && !sb.toString().equals("")){
            // Count how many way of permutation of n-1
            int cnt = 1 , i = sb.length() - 1;
            while (i > 1){
                cnt *= i;
                i -= 1;
            }
            // Key formula
            int pos = (k-1)/cnt;
            res += sb.charAt(pos);
            sb.deleteCharAt(pos);
            k -= pos*cnt;
        }
        return res;
    }
}
