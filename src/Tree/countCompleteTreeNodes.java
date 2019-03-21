package Tree;

/**
 * https://leetcode.com/problems/count-complete-tree-nodes/
 *
 */
public class countCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int leftDepth = countLeftDepth(root);
        int rightDepth = countRightDepth(root);
        // Complete binary tree
        if(leftDepth == rightDepth)
            return ( 1 << leftDepth) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int countLeftDepth(TreeNode root){
        if(root == null) return 0;
        int depth = 0;
        while(root!=null){
            root = root.left;
            depth++;
        }
        return depth;
    }

    private int countRightDepth(TreeNode root){
        if(root == null) return 0;
        int depth = 0;
        while(root!=null){
            root = root.right;
            depth++;
        }
        return depth;
    }
}
