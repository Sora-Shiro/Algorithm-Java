/*
输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
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

import java.util.ArrayList;
public class Solution {
    ArrayList<ArrayList<Integer>> resultAl = new ArrayList<>();
	
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null) return resultAl;
        find(root, target, 0, new ArrayList<Integer>());
        return resultAl;
    }
	
	private void find(TreeNode root, int target, int sum, ArrayList<Integer> al) {
		sum += root.val;
		al.add(root.val);
		if(sum == target){
			if(root.left != null || root.right != null) return;
			resultAl.add(al);
			return;
		} else if (sum > target){
			return;
		}
		
		if(root.left != null){
			ArrayList<Integer> leftAl = new ArrayList<>();
			leftAl.addAll(al);
			find(root.left, target, sum, leftAl);
		}
		if(root.right != null) {
			ArrayList<Integer> rightAl = new ArrayList<>();
			rightAl.addAll(al);
			find(root.right, target, sum, rightAl);
		}
	}
}

public class Solution {
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null) return listAll;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList<Integer>(list));
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size()-1);
        return listAll;
    }
}