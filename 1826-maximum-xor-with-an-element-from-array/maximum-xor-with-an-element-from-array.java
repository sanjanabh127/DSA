class Solution {

    static class TrieNode {
        TrieNode zero, one;
    }

    private void insert(TrieNode root, int num) {
        TrieNode curr = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (bit == 0) {
                if (curr.zero == null) curr.zero = new TrieNode();
                curr = curr.zero;
            } else {
                if (curr.one == null) curr.one = new TrieNode();
                curr = curr.one;
            }
        }
    }

    private int query(TrieNode root, int x) {
        TrieNode curr = root;
        if (curr.zero == null && curr.one == null) return -1; 
        
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (x >> i) & 1;
            if (bit == 0) {
                if (curr.one != null) {
                    result |= (1 << i);
                    curr = curr.one;
                } else {
                    curr = curr.zero;
                }
            } else {
                if (curr.zero != null) {
                    result |= (1 << i);
                    curr = curr.zero;
                } else {
                    curr = curr.one;
                }
            }
        }
        return result;
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);

        int q = queries.length;
        int[] result = new int[q];

        int[][] extended = new int[q][3]; 
        for (int i = 0; i < q; i++) {
            extended[i][0] = queries[i][0];
            extended[i][1] = queries[i][1];
            extended[i][2] = i;
        }
        Arrays.sort(extended, (a, b) -> Integer.compare(a[1], b[1]));

        TrieNode root = new TrieNode();
        int idx = 0; 

        for (int[] qr : extended) {
            int x = qr[0];
            int m = qr[1];
            int originalIndex = qr[2];

            while (idx < nums.length && nums[idx] <= m) {
                insert(root, nums[idx]);
                idx++;
            }

            result[originalIndex] = query(root, x);
        }

        return result;
    }
}
