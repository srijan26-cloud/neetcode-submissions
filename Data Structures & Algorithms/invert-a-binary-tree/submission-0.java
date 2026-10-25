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
        if(root == null)
            return null;
        //using dfs
        Stack<TreeNode> dfs = new Stack<>();
        dfs.push(root);
        while(!dfs.isEmpty()){
            
            TreeNode curr = dfs.pop();

            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;

            //push valid child to the stack
            if(curr.left != null)
                dfs.push(curr.left);
            if(curr.right != null)
                dfs.push(curr.right);
        }
        return root;
    }
}
