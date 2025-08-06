class Solution {
    int findmax(int[] piles) {
        int maxi = Integer.MIN_VALUE;
        int n = piles.length;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, piles[i]);
        }
        return maxi;
    }

    int calculateMinimum(int[] piles, int k) {
        int totalhrs = 0;
        int n = piles.length;
        for (int i = 0; i < n; i++) {
            totalhrs += Math.ceil((double) piles[i] / (double) k);
        }
        return totalhrs;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = findmax(piles);
        int ans = high;

        while (low <= high) {
            int mid = (low + high) / 2;
            int total = calculateMinimum(piles, mid);

            if (total <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
