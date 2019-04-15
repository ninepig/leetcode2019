package amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangw on 2019/4/11.
 */
public class combinationSum39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return res;
        }
        List<Integer> cur = new ArrayList<>();

        helper(res,cur,target,0,candidates);

        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> cur,int sum, int pos,int[] candidates) {
        if(sum < 0){
            return ;
        }else if(sum == 0){
            res.add(new ArrayList<>(cur));
        }else {
            for (int i = pos ; i < candidates.length ; i++ ){
                cur.add(candidates[i]);
                helper(res,cur,sum -  candidates[i],i,candidates);
                cur.remove(cur.size()-1);
            }
        }
    }
}
