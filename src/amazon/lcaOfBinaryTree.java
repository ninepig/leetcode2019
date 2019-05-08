package amazon;

/**
 * Created by yangw on 2019/4/3.
 */
public class lcaOfBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left!=null && right!=null) return root;
        if(left!=null) return left;
        if(right!=null) return right;

        return null;
    }
    public TreeNode lowestCommonAncestorBst(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;

        if(root.val > q.val && root.val > p.val){
            return lowestCommonAncestorBst(root.left , p , q);
        }
        if(root.val < q.val && root.val < p.val){
            return lowestCommonAncestorBst(root.right , p , q);
        }
        return root;
    }
}
