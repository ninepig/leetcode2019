package amazon;

/**
 * Created by yangw on 2019/4/11.
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
