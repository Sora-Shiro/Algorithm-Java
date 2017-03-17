/*
给定一颗二叉搜索树，请找出其中的第k大的结点。
例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
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
    TreeNode resultN = null;
	int outK = 0;
	boolean noDone = true;
	public TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot == null) return null;
		outK = k;
		find(pRoot);
		return resultN;
	}
	private void find(TreeNode pRoot){
		if(pRoot.left != null && noDone) find(pRoot.left);
		outK--;
		if(outK == 0) { 
			resultN = pRoot;
			noDone = false;
		}
		if(pRoot.right != null && noDone) find(pRoot.right);
	}
}