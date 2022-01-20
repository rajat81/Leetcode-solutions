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
import java.lang.Math;

class Solution {
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        solve(root);
        return ans;
    }
    
    private int solve(TreeNode root) {
        if(root == null) return 0;
        int l = solve(root.left);
        int r = solve(root.right);
        
        ans = Math.max(ans, l+r);
        return 1 + Math.max(l, r);
    }
}