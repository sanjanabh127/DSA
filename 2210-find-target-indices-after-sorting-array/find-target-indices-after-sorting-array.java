class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int foundIndex = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                foundIndex = mid;
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (foundIndex == -1) return result;
        int i = foundIndex;
        while (i >= 0 && nums[i] == target) {
            i--;
        }
        i++;
        while (i < nums.length && nums[i] == target) {
            result.add(i);
            i++;
        }
        return result;
    }
}
