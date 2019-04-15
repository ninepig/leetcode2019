package amazon;

import java.util.LinkedList;

/**
 * Created by yangw on 2019/4/13.
 */
public class minDepthTree {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null){
            return minDepth(root.right)+1;
        }
        if(root.right==null){
            return minDepth(root.left)+1;
        }

        return Math.min(minDepth(root.left),minDepth(root.right))+1;

    }

    public int minDepthBFS(TreeNode root) {
        if(root == null){
            return 0;
        }
        int level = 1;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int currentLevelSize = queue.size();
            while(currentLevelSize>0){
                TreeNode cur = queue.poll();
                if(cur.left == null && cur.right == null){
                    return level;
                }
                if(cur.left!=null){
                    queue.add(cur.left);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
                currentLevelSize--;
            }
            level++;
        }
        return level;
    }
}
