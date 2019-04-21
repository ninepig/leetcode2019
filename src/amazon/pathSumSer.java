package amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangw on 2019/4/16.
 */
public class pathSumSer {
    boolean ifExit = false;
    public boolean hasPathSum1(TreeNode root, int sum) {
        helper1(root, sum);
        return ifExit;
    }

    private void helper1(TreeNode root, int sum){
        if(root == null) return ;
        if(root.val == sum && root.left== null && root.right == null){
            ifExit = true;
        }
        helper1(root.left , sum - root.val);
        helper1(root.right, sum - root.val);
    }


    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper2(res,cur,root,sum);
        return res;
    }

    private void helper2(List<List<Integer>> res, List<Integer> cur, TreeNode root, int sum) {
        if(root == null) return;
        if (root.left == null && root.right == null && sum == root.val){
            res.add(new ArrayList<>(cur));
        }else{
            cur.add(root.val);
            helper2(res,cur,root.left,sum-root.val);
            helper2(res,cur,root.right,sum-root.val);
            cur.remove(cur.size()-1);
        }
    }

    public int pathSum3(TreeNode root, int sum) {
        if(root == null) return 0;

        return getSum(root,sum)+pathSum3(root.left,sum) + pathSum3(root.right,sum);
    }
    private int getSum(TreeNode root, int sum){
        int res = 0;
        if(root == null) return 0;

        if(root.val == sum)res++;

        res += getSum(root.left, sum-root.val);
        res += getSum(root.right, sum-root.val);

        return res;
    }

}
