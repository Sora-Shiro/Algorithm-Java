/*
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int[] preNums;
    public int[] inNums;
    public int i = 0;

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length == 0)
            return null;
        preNums = pre;
        inNums = in;

        int preRoot = pre[i++];
        return buildTree(preRoot, 0, in.length - 1);
    }

    public TreeNode buildTree(int root, int left, int right) {
        if (left > right) {
            i--;
            return null;
        }
        if (left == right) {
            TreeNode tn = new TreeNode(inNums[left]);
            return tn;
        }
        int rootIndex = left;
        for (; inNums[rootIndex] != root; rootIndex++) {
            ;
        }
        TreeNode tn = new TreeNode(inNums[rootIndex]);
        if(i < preNums.length){
            int nextLeftRoot = preNums[i++];
            tn.left = buildTree(nextLeftRoot, left, rootIndex - 1);
        }
        if(i < preNums.length){
            int nextRightRoot = preNums[i++];
            tn.right = buildTree(nextRightRoot, rootIndex + 1, right);
        }
        return tn;
    }
}

public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }
    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {
         
        if(startPre>endPre||startIn>endIn)
            return null;
        TreeNode root=new TreeNode(pre[startPre]);
         
        for(int i=startIn;i<=endIn;i++)
            if(in[i]==pre[startPre]){
                root.left=reConstructBinaryTree(pre,startPre+1,startPre-startIn+i,in,startIn,i-1);
                root.right=reConstructBinaryTree(pre,startPre-startIn+i+1,endPre,in,i+1,endIn);
            }
                 
        return root;
    }
}