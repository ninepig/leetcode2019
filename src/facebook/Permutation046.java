package facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangw on 2019/3/30.
 */
public class Permutation046 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(nums,res,cur,0);
        return res;
    }

    private void helper(int[] nums, List<List<Integer>> res, List<Integer> cur, int pos) {
        if(cur.size() == nums.length){
            res.add(new ArrayList<>(cur));
        }else{
            for ( int i = pos ; i < nums.length ; i++){
                if(cur.contains(nums[i]))continue;
                cur.add(nums[i]);
                helper(nums,res,cur,pos);
                cur.remove(cur.size()-1);
            }
        }

    }

}
