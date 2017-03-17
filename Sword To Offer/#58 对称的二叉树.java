/*
请实现一个函数，用来判断一颗二叉树是不是对称的。
注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
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
import java.util.HashMap;
import java.util.ArrayList;
public class Solution {
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
	public boolean isSymmetrical(TreeNode pRoot) {
		if(pRoot == null) return true;
        addToList(pRoot, 1);
		for(int i = 1; ;i++){
			if(map.get(i) == null) break;
			ArrayList<Integer> check = map.get(i);
			for(int j = 0; j < check.size()/2; j++){
				if(check.get(j) != check.get(check.size()-j-1)) return false;
			}
		}
		return true;
    }
	
	private void addToList(TreeNode n, int i) {
		if(map.get(i) == null) map.put(i, new ArrayList<Integer>());
		ArrayList<Integer> save = map.get(i);
		if(n != null) save.add(n.val);
		else {
			save.add(null);
			return;
		}
		if(n.left != null) addToList(n.left, i+1);
		else addToList(null, i+1);
		if(n.right != null) addToList(n.right, i+1);
		else addToList(null, i+1);
	}
}

public class Solution {
    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        return f(pRoot.left,pRoot.right);
    }
    private boolean f(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) 
            return true;
        if (t1 != null && t2 != null) 
            return t1.val == t2.val && f(t1.left,t2.right) && f(t1.right, t2.left);
        return false;
    }
}