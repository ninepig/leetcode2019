package amazon;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yangw on 2019/3/29.
 */
public class SandDBinaryTree297 {
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if (temp == null){
                sb.append("null");
                continue;
            }
            sb.append(temp.val);
            queue.offer(temp.left);
            queue.offer(temp.right);
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] nodes = data.split("\\s+");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1 ; i < data.length() ; i++){
            TreeNode  cur = queue.poll();
            if(!nodes[i].equals("null")){
                cur.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(cur.left);
            }
            if(!nodes[++i].equals("null")){
                cur.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(cur.right);
            }
        }
        return root;
    }
}