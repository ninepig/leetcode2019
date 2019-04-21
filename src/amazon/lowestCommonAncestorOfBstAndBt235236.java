package amazon;

/**
 * Created by yangw on 2019/4/16.
 */
public class lowestCommonAncestorOfBstAndBt235236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null||root==q||root==p){
            return root;
        }
        TreeNode left =  lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left!=null&&right!=null){
            return root;
        }
        if(left!=null){
            return left;
        }
        if(right!=null){
            return right;
        }

        return null;

    }
    public TreeNode lowestCommonAncestorBst(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null ) return root;
        if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestorBst(root.right,p,q);
        }
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestorBst(root.left,p,q);
        }
        return root;

    }
}
