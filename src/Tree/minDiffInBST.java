package Tree;

import java.util.Stack;

/**
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 * 783
 * 利用tree的 stack 的inorder 遍历即可， 维护一个之前的结点，然后遍历一遍即可。
 */

/**
 * Created by yangw on 2018/12/23.
 */
public class minDiffInBST {
    public int minDiffInBST(TreeNode root) {
        int result = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null) result = Math.min(Math.abs(pre.val - root.val),result);
            pre = root;
            root = root.right;
        }

        return result;
    }
}
