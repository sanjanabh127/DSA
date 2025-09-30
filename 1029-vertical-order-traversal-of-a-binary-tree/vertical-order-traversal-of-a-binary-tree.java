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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // Map: column -> (row -> list of node values)
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> columnTable = new TreeMap<>();
        // Queue for BFS: stores node along with its row and column
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 0, 0));

        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            TreeNode node = tuple.node;
            int row = tuple.row;
            int col = tuple.col;

            columnTable.putIfAbsent(col, new TreeMap<>());
            columnTable.get(col).putIfAbsent(row, new PriorityQueue<>());
            columnTable.get(col).get(row).offer(node.val);

            if (node.left != null) {
                queue.offer(new Tuple(node.left, row + 1, col - 1));
            }
            if (node.right != null) {
                queue.offer(new Tuple(node.right, row + 1, col + 1));
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> rows : columnTable.values()) {
            List<Integer> colList = new ArrayList<>();
            for (PriorityQueue<Integer> pq : rows.values()) {
                while (!pq.isEmpty()) {
                    colList.add(pq.poll());
                }
            }
            result.add(colList);
        }

        return result;
    }

    // Helper class to store node with its row and column
    class Tuple {
        TreeNode node;
        int row, col;
        Tuple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
}