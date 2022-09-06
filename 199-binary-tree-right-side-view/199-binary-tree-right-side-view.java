/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    List<Integer> ans = new ArrayList<>();
    int level = 0;
    public List<Integer> rightSideView(TreeNode root) {
        process(root, 1);
        return ans;
    }
    
    private void process(TreeNode root, int height) {
        if(root == null) return;
        
        if(height > level) {
            ans.add(root.val);
            level++;
        }
        
        height += 1;
        
        process(root.right, height);
        process(root.left, height);
    }
}