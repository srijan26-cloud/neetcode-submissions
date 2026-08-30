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
    int maxSum;
    private int solve(TreeNode root){
        if(root == null)
            return 0;
        
        int l = solve(root.left);
        int r = solve(root.right);
        //1 - left se accha + right se accha + root-> val
        // recurrsion me use nhi kr skte (already ans)
        int uTurnOnlyAns = l+r+root.val;
        //2 - left ya right accha + root-> val
        int eitherSideAndRoot = Math.max(l, r)+root.val;
        //3 - left && right accha nhi -> only root
        int rootItself = root.val;

        //max of condition : 1 2 3
        maxSum = Math.max(maxSum, Math.max(uTurnOnlyAns, Math.max(eitherSideAndRoot, rootItself)));

        //return max of conditon : 2 & 3 and not 1 as its the ans itself & not path for recurrsion
        return Math.max(eitherSideAndRoot , rootItself);
    }
    public int maxPathSum(TreeNode root) {
        maxSum=Integer.MIN_VALUE;
        solve(root);
        return maxSum;
    }
}
