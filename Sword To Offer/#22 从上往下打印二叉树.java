/*
从上往下打印出二叉树的每个节点，同层节点从左至右打印。
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
import java.util.HashMap;
public class Solution {
    HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<>();	
		if (root == null) return result;
		
		add(0, root);
		
		ArrayList<Integer> layerList;
		int layer = 0;
		while(hm.get(layer) != null) {
			layerList = hm.get(layer);
			for(int i = 0; i < layerList.size(); i++){
				result.add(layerList.get(i));
			}
			layer++;
		}
		
		return result;
	}
	private void add(int layer, TreeNode root) {
		ArrayList<Integer> al;
		if(hm.get(layer) == null) {
			al = new ArrayList<>();
			hm.put(layer, al);
		}
		al = hm.get(layer);
		
		al.add(root.val);
		
		if(root.left != null) add(layer+1, root.left);
		if(root.right != null) add(layer+1, root.right);
	}
}

public class Solution {
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<TreeNode> listNode = new ArrayList<TreeNode>();
		ArrayList<Integer> listVal = new ArrayList<Integer>();
		if (root == null)
			return listVal;

		listNode.add(root);
		listVal.add(root.val);
		
		for (int i = 0; i < listNode.size(); i++) {
			TreeNode node = listNode.get(i);
			if (node.left != null) {
				listNode.add(node.left);
				listVal.add(node.left.val);
			}
			if (node.right != null) {
				listNode.add(node.right);
				listVal.add(node.right.val);
			}

		}

		return listVal;
	}
}