class Solution {
    private boolean subsetSum(int n, int k, int[] arr) {
        boolean[] prev = new boolean[k + 1];
        boolean[] curr = new boolean[k + 1];

        prev[0] = true;
        curr[0] = true;

        if (arr[0] <= k)
            prev[arr[0]] = true;

        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                boolean notTake = prev[target];
                boolean take = false;
                if (arr[ind] <= target)
                    take = prev[target - arr[ind]];

                curr[target] = take || notTake;
            }
            prev = curr.clone(); 
        }

        return prev[k];
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;

        if (sum % 2 != 0)
            return false;

        int target = sum / 2;
        int n = nums.length;

        return subsetSum(n, target, nums);
    }
}
