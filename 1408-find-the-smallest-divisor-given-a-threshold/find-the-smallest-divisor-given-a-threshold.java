

class Solution {
    private int sumD(int[] arr, int div) {
        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            sum += Math.ceil((double) arr[i] / (double) div);
        }
        return sum;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int ans = -1;
        int low = 1;
        int high = Arrays.stream(nums).max().getAsInt();

        while (low <= high) {
            int mid = (low + high) / 2;  

            if (sumD(nums, mid) <= threshold) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
