/*
从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
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
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(pRoot == null) return result;
        addToList(pRoot, 1);
        for(int i = 1; ;i++){
            if(map.get(i) == null) break;
            ArrayList<Integer> arrange = map.get(i);
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

/*
* 队列LinkedList完成层序遍历，用end记录每层结点数目
*/
public class Solution {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null){
            return result;
        }
        Queue<TreeNode> layer = new LinkedList<TreeNode>();
        ArrayList<Integer> layerList = new ArrayList<Integer>();
        layer.add(pRoot);
        int start = 0, end = 1;
        while(!layer.isEmpty()){
            TreeNode cur = layer.remove();
            layerList.add(cur.val);
            start++;
            if(cur.left!=null){
                layer.add(cur.left);            
            }
            if(cur.right!=null){
                layer.add(cur.right);
            }
            if(start == end){
                end = layer.size();
                start = 0;
                result.add(layerList);
                layerList = new ArrayList<Integer>();
            }
        }
        return result;
    }
}