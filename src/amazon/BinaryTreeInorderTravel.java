package amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yangw on 2019/4/3.
 */
public class BinaryTreeInorderTravel {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> s = new Stack<>();
        while(root!=null || !s.isEmpty()){
            while (root!= null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
