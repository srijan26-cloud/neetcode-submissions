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

    int max_sum;

    int solve(TreeNode root){
        if(root==null) return 0;

        int left=solve(root.left);
        int right=solve(root.right);

        int ekSideSeAns=root.val+Math.max(left,right);
        int rootSeAns=root.val;
        int ekHiAns=root.val+left+right;

        max_sum=Math.max(max_sum,Math.max(rootSeAns,Math.max(ekSideSeAns,ekHiAns)));

        return Math.max(ekSideSeAns,rootSeAns);

    }

    public int maxPathSum(TreeNode root) {
        max_sum=Integer.MIN_VALUE;

        solve(root);

        return max_sum;
    }
}
