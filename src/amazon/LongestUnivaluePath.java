package amazon;

/**
 * Created by yangw on 2019/4/15.
 */
public class LongestUnivaluePath {
    int longest = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        helper(root, root.val);
        return longest;
    }

    private int helper(TreeNode node, int val) {
        if (node == null) return 0;
        int left = helper(node.left,node.val);
        int right = helper(node.right,node.val);
        longest = Math.max(longest, left + right);
        if (node.val == val) return Math.max(left,right) + 1;
        return 0;
    }
}
