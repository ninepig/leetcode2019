package amazon;

/**
 * Created by yangw on 2019/4/13.
 */
public class maxDepthTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) +1;



//        if(root == null){
//            return 0;
//        }
//        Queue<TreeNode> q = new LinkedList();
//        q.offer(root);
//        int level = 0;
//        while(!q.isEmpty()){
//            int size = q.size();
//            while(size>0){
//                TreeNode node = q.poll();
//                if(node.left!=null){
//                    q.offer(node.left);
//                }
//                if(node.right!=null){
//                    q.offer(node.right);
//                }
//                size--;
//            }
//            level++;
//        }
//        return level;
    }
}
