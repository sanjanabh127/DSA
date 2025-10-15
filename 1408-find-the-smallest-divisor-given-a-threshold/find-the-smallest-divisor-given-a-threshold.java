class Solution {
    private int sumD(int[] arr,int divisor){
        int n=arr.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum=sum+(int)Math.ceil((double)arr[i] / divisor);
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int n=nums.length;
        
        if(n>threshold)return -1;
        int low=1;
        int high = nums[0];
       for (int i = 1; i < nums.length; i++) {
            if (nums[i] > high) {
                  high = nums[i];
                }
       }
        int ans = -1; 
        while(low<=high){
            int mid=(low+high)/2;
            if(sumD(nums,mid)<=threshold){
                 ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
        
    }
}