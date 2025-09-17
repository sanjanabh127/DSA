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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }

        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return built(inorder, 0, inorder.length - 1,
                     postorder, 0, postorder.length - 1, inMap);
    }

    private TreeNode built(int[] inorder, int si, int ei,
                           int[] postorder, int ps, int pe,
                           Map<Integer, Integer> inMap) {
        if (ps > pe || si > ei) return null;

        TreeNode root = new TreeNode(postorder[pe]);
        int inRoot = inMap.get(postorder[pe]);
        int numsLeft = inRoot - si;

        root.left = built(inorder, si, inRoot - 1,
                          postorder, ps, ps + numsLeft - 1, inMap);

        root.right = built(inorder, inRoot + 1, ei,
                           postorder, ps + numsLeft, pe - 1, inMap);

        return root;
    }
}
