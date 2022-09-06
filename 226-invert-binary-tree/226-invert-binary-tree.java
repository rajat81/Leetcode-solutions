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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        
        TreeNode right = invertTree(root.left);
        TreeNode left = invertTree(root.right);
        
        TreeNode temp = new TreeNode(root.val, left, right);
        return temp;
    }
    
    
    private void invertBinaryTree(TreeNode a, TreeNode b) {
        if(a == null && b == null) return;
        
        int t = b.val;
        b.val = a.val;
        a.val = t;
        
        invertBinaryTree(a.left, b.right);
        invertBinaryTree(a.right, b.left);
    }
}