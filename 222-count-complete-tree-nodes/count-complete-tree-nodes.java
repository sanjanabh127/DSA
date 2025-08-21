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
    public int countNodes(TreeNode root) {
        
        int left=getleft(root);
        int right=getright(root);
        if(left==right)  return (1 << (left + 1)) - 1;
        else return countNodes(root.left)+countNodes(root.right)+1;
    }
    public int getleft(TreeNode root){
        int count=0;
        while(root!=null){
            count++;
            root=root.left;
        }
        return count-1;
    }
    public int getright(TreeNode root){
        int count=0;
        while(root!=null){
            count++;
            root=root.right;
        }
        return count-1;
    }
}