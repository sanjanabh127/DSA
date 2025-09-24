class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int height = heights[st.pop()];
                int pse = st.isEmpty() ? -1 : st.peek(); 
                int nse = i; 
                maxArea = Math.max(maxArea, height * (nse - pse - 1));
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            int height = heights[st.pop()];
            int pse = st.isEmpty() ? -1 : st.peek();
            int nse = n; 
            maxArea = Math.max(maxArea, height * (nse - pse - 1));
        }

        return maxArea;
    }
}
