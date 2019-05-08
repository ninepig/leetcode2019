package amazon.MianJing;

/**
 * Created by yangw on 2019/4/28.
 */
public class sumOfAllSubTree {

     int sum = 0;
     public int countSum(TreeNode root){
         if(root == null){
             return 0;
         }
         helper(root);
         return sum;
     }

    private int helper(TreeNode root) {
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        sum = left + right + root.val;
        return sum;
    }

    public static void main(String ... args){
        sumOfAllSubTree test = new sumOfAllSubTree();
        TreeNode a = new TreeNode(3);
        a.left = new TreeNode(2);
        a.left.left = new TreeNode(1);
        a.left.right = new TreeNode(2);
        a.right = new TreeNode(3);
        a.right.right = new TreeNode(2);
        a.right.left = new TreeNode(1);
        System.out.println(test.countSum(a));
     }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
