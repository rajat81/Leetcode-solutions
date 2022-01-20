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
    public int diameterOfBinaryTree(TreeNode root) {
        // int ans = 1;
        // depth(root);
        // return ans-1;
        int[] res = new int[1]; // for pass by ref
        res[0] = Integer.MIN_VALUE; 
        
        solve(root, res);
        return res[0]-1;
    }
    
    private int solve(TreeNode root, int[] res) {
        if(root == null) return 0;
        int l = solve(root.left, res);
        int r = solve(root.right, res);
        
        int ans = Integer.max(l, r);
        res[0] = Integer.max(res[0], l + r +1);
        return Integer.max(l, r) + 1;       // return the max height till that part
    }
}