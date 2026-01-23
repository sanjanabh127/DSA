class Solution {
    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = -1; 
        for (int i = n - 1; i >= 0; i--) {
            int minCuts = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j)) {
                    minCuts = Math.min(minCuts, 1 + dp[j + 1]);
                }
            }
            dp[i] = minCuts; 
        }
        return dp[0];
    }
}
