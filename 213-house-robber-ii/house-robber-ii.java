

class Solution {
    private int robLinear(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int prev = nums[0];
        int prev2 = 0;

        for (int i = 1; i < n; i++) {
            int take = nums[i];
            if (i > 1) take += prev2;
            int notTake = prev;
            int curr = Math.max(take, notTake);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int[] temp1 = new int[n - 1]; 
        int[] temp2 = new int[n - 1];

        for (int i = 0; i < n; i++) {
            if (i != 0) temp1[i - 1] = nums[i];
            if (i != n - 1) temp2[i] = nums[i];
        }

        return Math.max(robLinear(temp1), robLinear(temp2));
    }
}
