class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] dp = new int[m + 1];
       for (int i = 1; i <= n; i++) {
            int[] dp2 = new int[m + 1];
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp2[j] = 1 + dp[j - 1];
                } else {
                    dp2[j] = Math.max(dp[j], dp2[j - 1]);
                }
            }
            dp = dp2;
        }
        int lcs = dp[m];
        return (n - lcs) + (m - lcs);
    }
}
