package amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yangw on 2019/4/2.
 */
public class binaryTreeLevelOrder102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()){
            List<Integer> cur = new ArrayList<>();
            int curLevelSize = q.size();
            for (int i = 0 ; i < curLevelSize ; i++){
                TreeNode curNode = q.poll();
                cur.add(curNode.val);
                if(curNode.left!=null) q.offer(curNode.left);
                if(curNode.right!=null) q.offer(curNode.right);
            }
            res.add(cur);
        }
        return res;
    }
}
