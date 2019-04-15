package amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yangw on 2019/3/31.
 */
public class binaryTreeZigZagLevelOrder103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 1;
        while (!q.isEmpty()){
            int curSize = q.size();
            List<Integer> cur = new ArrayList<>();
            for (int i = 0 ;  i < curSize ; i++){
                TreeNode curNode = q.poll();
                if(level % 2 == 1){
                    cur.add(curNode.val);
                }else{
                    cur.add(0,curNode.val);
                }
                if(curNode.left!=null) q.offer(curNode.left);
                if(curNode.right!=null)q.offer(curNode.right);
            }
            res.add(cur);
            level++;
        }
        return res;
    }
}
