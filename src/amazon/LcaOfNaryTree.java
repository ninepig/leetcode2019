package amazon;

import java.util.ArrayList;

/**
 * Created by yangw on 2019/5/6.
 */
public class LcaOfNaryTree {
    // Give the common ancestor of all the deepest nodes of a tree：
    public TreeNodeS lowestCommonAncestor(TreeNodeS root){
        return dfs(root, 0).node;
    }

    private ResultType dfs(TreeNodeS root, int depth){
        if (root == null){
            return new ResultType(root, 0);
        }
        int maxDepth = 0;
        int count = 0;
        TreeNodeS maxDepthNode = null;

        for (TreeNodeS child : root.children){
            ResultType temp = dfs(child, depth);
            int tempDepth = temp.depth;
            if (tempDepth + 1 > maxDepth){
                maxDepth = tempDepth + 1;
                maxDepthNode = temp.node;
                count = 1;
            } else if (tempDepth + 1 == maxDepth){
                count++;
            }
        }

        if (count > 1){
            return new ResultType(root, depth);
        } else {
            return new ResultType(maxDepthNode, maxDepth);
        }
    }

}

class TreeNodeS{
    int val;
    ArrayList<TreeNodeS> children;//多叉树
    public TreeNodeS(int val){
        this.val = val;
        this.children = new ArrayList<>();
    }
}

class ResultType{
    TreeNodeS node; //返回的节点
    int depth; //以该返回节点为根的树里最深的节点的深度depth
    public ResultType(TreeNodeS node, int depth){
        this.node = node;
        this.depth = depth;
    }
}
