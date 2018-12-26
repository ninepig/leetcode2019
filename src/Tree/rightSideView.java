package Tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 199
 * https://leetcode.com/problems/binary-tree-right-side-view
 * Created by yangw on 2018/12/25.
 */
public class rightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null ) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        helper(res,root,0);
        return res;
    }
    private void helper(List<Integer> res , TreeNode node, int level){
        if(node == null) return;
        if(level == res.size()) res.add(node.val);
        // 先把右侧的节点加入，利用先走右侧的这个特性，把所有的都加入，这个是需要记忆的方法，dfs
        helper(res,node.right,level+1);
        helper(res,node.left,level+1);
    }
    // BFS , last element of the current level.
    public List<Integer> rightSideViewBFS(TreeNode root) {
        if(root == null ) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ;i < size;i++){
                TreeNode cur = q.poll();
                if(i == 0) res.add(cur.val);
                if(cur.right!=null) q.offer(cur.right);
                if(cur.left!=null)q.offer(cur.left);
            }
        }
        return res;
    }
}
