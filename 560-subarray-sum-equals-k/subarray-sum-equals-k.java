
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); 
        int presum = 0, cnt = 0;
        for (int num : nums) {
            presum += num;
            int remove = presum - k;
            cnt += map.getOrDefault(remove, 0);
            map.put(presum, map.getOrDefault(presum, 0) + 1);
        }
        return cnt;
    }
}
