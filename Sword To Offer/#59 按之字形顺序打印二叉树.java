/*
请实现一个函数按照之字形打印二叉树，
即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
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
import java.util.Collections;
public class Solution {
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(pRoot == null) return result;
        addToList(pRoot, 1);
        for(int i = 1; ;i++){
            if(map.get(i) == null) break;
            ArrayList<Integer> arrange = map.get(i);
            if(i % 2 == 0) Collections.reverse(arrange);
            result.add(arrange);
        }
        return result;
    }
    
    private void addToList(TreeNode n, int i) {
        if(map.get(i) == null) map.put(i, new ArrayList<Integer>());
        ArrayList<Integer> save = map.get(i);
        save.add(n.val);
        if(n.left != null) addToList(n.left, i+1);
        if(n.right != null) addToList(n.right, i+1);
    }

}