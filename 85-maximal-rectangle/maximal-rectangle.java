class Solution {
    private int largestArea(int[] histo) {
        Stack<Integer> stack = new Stack<>();
        int maxA = 0;
        int n = histo.length;
        for (int i = 0; i <= n; i++) {
            int currHeight = (i == n) ? 0 : histo[i];
            while (!stack.isEmpty() && currHeight < histo[stack.peek()]) {
                int height = histo[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxA = Math.max(maxA, width * height);
            }
            stack.push(i);
        }
        return maxA;
    }
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int n = matrix.length;
        int m = matrix[0].length;
        int[] height = new int[m];
        int maxA = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1')
                    height[j]++;
                else
                    height[j] = 0;
            }

            int area = largestArea(height);
            maxA = Math.max(maxA, area);
        }
        return maxA;
    }
}
