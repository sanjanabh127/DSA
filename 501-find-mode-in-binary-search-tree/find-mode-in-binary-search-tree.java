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
    public int[] findMode(TreeNode root) {
        Map<Integer,Integer> map=new HashMap();
        traverse(root,map);
        int max=Collections.max(map.values());
        List<Integer> result =new ArrayList<>();
        for(int key:map.keySet()){
            if(map.get(key)==max)
            result.add(key);
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
    private void traverse(TreeNode node,Map<Integer,Integer> map){
        if(node==null)return ;
        map.put(node.val,map.getOrDefault(node.val,0)+1);
        traverse(node.left,map);
        traverse(node.right,map);
    }
}