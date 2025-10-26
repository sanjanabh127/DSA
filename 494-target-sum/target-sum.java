class Solution {
    private int findWays(int[] nums, int target) {
        int n = nums.length;
        int[] prev = new int[target + 1];
        int[] cur = new int[target + 1];
        if (nums[0] == 0) prev[0] = 2; 
        else prev[0] = 1;
        if (nums[0] != 0 && nums[0] <= target) 
            prev[nums[0]] = 1;
        for (int ind = 1; ind < n; ind++) {
            for (int sum = 0; sum <= target; sum++) {
                int notTake = prev[sum];
                int take = 0;
                if (nums[ind] <= sum) take = prev[sum - nums[ind]];
                cur[sum] = (notTake + take);
            }
            prev = cur.clone();
        }
        return prev[target];
    }

    private int countP(int n, int diff, int[] arr) {
        int totalSum = 0;
        for (int num : arr) totalSum += num;
        if (totalSum - diff < 0 || (totalSum - diff) % 2 != 0)
            return 0;
        int target = (totalSum - diff) / 2;
        return findWays(arr, target);
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return countP(n, target, nums);
    }
}
