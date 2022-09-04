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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        
        int ans = findMaxHt(root);
        
        if(ans < 0) return false;
        return true;
    }
    
    private int findMaxHt(TreeNode root) {
        if(root == null) return 0;
        
        int left = findMaxHt(root.left);
        int right = findMaxHt(root.right);
        if(left == -1 || right == -1) return -1;
        
        
        if(Math.abs(left - right) <= 1) {
            return Integer.max(left, right) +1;
        }
        
        return -1;
    }
}