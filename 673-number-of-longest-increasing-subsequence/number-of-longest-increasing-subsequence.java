class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int[] curr=new int[n];
        Arrays.fill(curr,1);
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int maxi=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i] && dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                    curr[i]=curr[j];
                }
                else if(nums[j]<nums[i] && dp[j]+1==dp[i]){
                    curr[i]=curr[j]+curr[i];
                }
            }
            maxi=Math.max(maxi,dp[i]);
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(dp[i]==maxi){
                count+=curr[i];
            }
        }
        return count ;
    }
}