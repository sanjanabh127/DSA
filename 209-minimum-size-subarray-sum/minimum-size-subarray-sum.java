class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int sum =0;
        int minlen=Integer.MAX_VALUE;
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
        while(sum>=target){
            minlen=Math.min(minlen,right-left+1);
            sum-=nums[left];
            left++;
        }
    }
    return minlen==Integer.MAX_VALUE ? 0:minlen;
    }
}