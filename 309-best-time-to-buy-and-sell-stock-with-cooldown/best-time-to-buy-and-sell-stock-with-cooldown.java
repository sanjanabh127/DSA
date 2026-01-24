class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] cur = new int[2];
        int[] front1 = new int[2];
        int[] front2 = new int[2];
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;

                if (buy == 0) { 
                    profit = Math.max(0 + front1[0], -prices[ind] + front1[1]);
                }

                if (buy == 1) { 
                    profit = Math.max(0 + front1[1], prices[ind] + front2[0]);
                }

                cur[buy] = profit;
            }
            System.arraycopy(front1, 0, front2, 0, 2);
            System.arraycopy(cur, 0, front1, 0, 2);
        }
        return cur[0];
    }
        
    
}