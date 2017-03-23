/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    Queue<TreeNode> pp = new LinkedList<TreeNode>();
    Queue<TreeNode> qq = new LinkedList<TreeNode>();
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        find(root, p, pp);
        find(root, q, qq);
        TreeNode result = null;
        while (!pp.isEmpty() && !qq.isEmpty()) {
            if(pp.peek() != qq.peek()) break;
            result = pp.poll();
            qq.poll();
        }
        return result;
    }
    
    private void find (TreeNode root, TreeNode target, Queue<TreeNode> queue) {
        queue.add(root);
        if (root.val != target.val) {
            if(target.val < root.val) find(root.left, target, queue);
            if(target.val > root.val) find(root.right, target, queue);
        }
    }
}

public class Solution_clear {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val - p.val) * (root.val - q.val) > 0)
        root = p.val < root.val ? root.left : root.right;
        return root;
    }
}