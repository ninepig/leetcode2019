package facebook;

import java.util.Stack;

/**
 * Created by yangw on 2019/3/30.
 */
public class validBst098 {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && pre.val > root.val){
                return false;
            }
            pre = root;
            root = root.right;
        }
        return true;
    }
}
