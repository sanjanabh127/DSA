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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder=new ArrayList<>();
        if(root==null){
            return postorder;
        }
        else{
            postorder.addAll(postorderTraversal(root.left));
            postorder.addAll(postorderTraversal(root.right));
            postorder.add(root.val);
        }
        return postorder;
        
    }
}