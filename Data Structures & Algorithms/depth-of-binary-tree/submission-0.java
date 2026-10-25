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
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        
        return findDepth(root, 0);
    }
    private int findDepth(TreeNode root, int c){
        if(root == null)
            return c;
        return 1+Math.max(findDepth(root.left,c),findDepth(root.right,c));
    }
}
