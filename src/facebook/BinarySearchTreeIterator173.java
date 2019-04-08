package facebook;

import java.util.Stack;

/**
 * Created by yangw on 2019/4/4.
 */
public class BinarySearchTreeIterator173 {
    Stack<TreeNode> s ;
    TreeNode current;
    public BinarySearchTreeIterator173(TreeNode root) {
        s = new Stack<>();
        current = root;
    }

    /** @return the next smallest number */
    public int next() {
        while (current!=null){
            s.push(current);
            current = current.left;
        }
        TreeNode temp = s.pop();
        current = temp.right;
        return temp.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (!s.isEmpty()||(current!=null));
    }
}
