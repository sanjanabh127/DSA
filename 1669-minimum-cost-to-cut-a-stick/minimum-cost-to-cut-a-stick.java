class Solution {
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        int[] newCuts = new int[c + 2];
        newCuts[0] = 0;
        newCuts[c + 1] = n;
        for (int i = 0; i < c; i++) {
            newCuts[i + 1] = cuts[i];
        }
        Arrays.sort(newCuts);
        int[][] dp = new int[c + 2][c + 2];
        for (int i = c; i >= 1; i--) {
            for (int j = i; j <= c; j++) {
                int mini = Integer.MAX_VALUE;
                for (int ind = i; ind <= j; ind++) {
                    int cost = newCuts[j + 1] - newCuts[i - 1]
                             + dp[i][ind - 1]
                             + dp[ind + 1][j];

                    mini = Math.min(mini, cost);
                }

                dp[i][j] = mini;
            }
        }

        return dp[1][c];
    }
}
