/*
输入一棵二叉树，求该树的深度。
从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
*/

public class Solution {
    int maxDepth = 0;
    public int TreeDepth(TreeNode root) {
        if(root != null){
            findNext(root, 0);
        }
        return maxDepth;
    }
    
    private void findNext(TreeNode root, int depth){
        depth++;
        if(root.left != null) findNext(root.left, depth);
        if(root.right != null) findNext(root.right, depth);
        if(root.left == null && root.right == null){
            if(depth > maxDepth) maxDepth = depth;
        }
    }
}

public class Solution {
    public int TreeDepth(TreeNode pRoot) {
        return pRoot == null ? 0 : Math.max(TreeDepth(pRoot.left), TreeDepth(pRoot.right)) + 1;
    }
}