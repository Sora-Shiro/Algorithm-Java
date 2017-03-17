/*
输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
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
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {

        if (root1 == null || root2 == null) return false;

        TreeNode result = null;
        boolean isSub = false;

        result = find(root1, root2);

        if (result != null) isSub = checkSubtree(root1, root2);

        boolean checkLeft = false;
        boolean checkRight = false;
        
        if (isSub == false) {
            checkLeft = HasSubtree(root1.left, root2);
            checkRight = HasSubtree(root1.right, root2);
        } else {
            return true;
        }

        isSub = checkLeft || checkRight;

        return isSub;
    }

    public TreeNode find(TreeNode root1, TreeNode root2) {
        if (root1.val == root2.val) {
            return root1;
        } else {
            return null;
        }
    }

    public boolean checkSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        boolean left = false;
        boolean right = false;
        
        if (root1.left != null && root2.left != null) {
            left = checkSubtree(root1.left, root2.left);
        } else if (root2.left == null) {
            left = true;
        }
        
        if (root1.right != null && root2.right != null) {
            right = checkSubtree(root1.right, root2.right);
        } else if (root2.right == null) {
            right = true;
        }
        
        if (root1.val == root2.val) {
            result = true;
        }
        
        return result && left && right;
    }
}

public class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if(root1 != null && root2 != null){
            if(root1.val == root2.val){
                result = DoesTree1HaveTree2(root1,root2);
            }
            if(!result){result = HasSubtree(root1.left, root2);}
            if(!result){result = HasSubtree(root1.right, root2);}
        }
        return result;
    }
    public boolean DoesTree1HaveTree2(TreeNode root1,TreeNode root2){
        if(root1 == null && root2 != null) return false;
        if(root2 == null) return true;
        if(root1.val != root2.val) return false;
        return DoesTree1HaveTree2(root1.left, root2.left) 
            && DoesTree1HaveTree2(root1.right, root2.right);
    }
}