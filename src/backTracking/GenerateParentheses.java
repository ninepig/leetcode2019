package backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 22
 * backtracking 维护括号的数量，枚举所有可能性
 * Created by yangw on 2018/12/24.
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n == 0) return res;
        helper(res,n,0,0,"");
        return res;
    }

    private void helper(List<String> res, int n, int left, int right, String s) {
        if(s.length()>=2*n){
            res.add(s);
        }
        if(left<n){
            helper(res,n,left+1,right,s+"(");
        }
        if(right<left){
            helper(res,n,left,right+1,s+")");
        }
    }
}
