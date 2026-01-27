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
    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }
    private int dfs(TreeNode root,int current){
        if(root==null)return 0;
        current=current*10+root.val;
        if(root.left==null&&root.right==null){
            return current;
        }
        return dfs(root.left,current)+dfs(root.right,current);
    }
}