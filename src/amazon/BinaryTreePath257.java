package amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangw on 2019/4/15.
 */
public class BinaryTreePath257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null){
            return res;
        }

        dfs(res,root,"");

        return res;

    }

    private void dfs(List<String> res, TreeNode root, String s) {
        if (root == null) return;
        if(root.left == null && root.right == null){
            res.add(s+root.val);
        }
        if(root.left!=null){
            dfs(res,root.left,s+root.val+"->");
        }
        if(root.right!=null){
            dfs(res,root.right,s+root.val+"->");
        }
    }
}
