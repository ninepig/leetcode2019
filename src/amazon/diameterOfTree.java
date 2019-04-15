package amazon;

/**
 * Created by yangw on 2019/4/4.
 */
public class diameterOfTree {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
            helper(root);
            return max;
    }

    private int helper(TreeNode root) {
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);

        max = Math.max(max,left+right);

        return Math.max(left,right)+1;
    }

}
