package amazon;

/**
 * Created by yangw on 2019/4/11.
 * 画图做，先从左边开始删
 * 在从右边开始删除
 * 如果当前节点是目标节点。如果左边没有的话，节点就直接删除。
 * 如果右边没有的话，节点删除，用左侧的取代节点即可
 * 如果左右都有的话，先要找到右侧最小的，然后用这个点取代节点。同时继续找下去。
 */
public class DeleteNodeInaBST450 {
    public TreeNode deleteNode(TreeNode root, int key) {
            if(root == null) return root;
            if(root.val > key){
                // 从左子树开始删除
                root.left = deleteNode(root.left,key);
            }else if(root.val < key){
                // 从右子树开始删除
                root.right = deleteNode(root.right,key);
            }else {
                if(root.left  == null){
                    root = root.right;
                }else if(root.right == null){
                    root = root.left;
                }
                TreeNode minNode = finMin(root.right);
                root.val = minNode.val;
                root.right = deleteNode(root.right,key);
            }
            return root;
    }

    private TreeNode finMin(TreeNode root) {
        while (root.left!=null){
            root = root.left;
        }
        return root;
    }
}
