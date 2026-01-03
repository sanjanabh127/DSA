class Solution {
    public int splitArray(int[] nums, int k) {
        int low=0,high=0;
        for(int num:nums){
            low=Math.max(low,num);
            high+=num;
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(cansplit(nums,k,mid)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
        
    }
    private boolean cansplit(int[] arr,int n,int m){
        int subarray=1;
        int currentsum=0;
        for(int num:arr){
            if(currentsum+num>m){
                subarray++;
                currentsum=num;
                if(subarray>n)return false;
            }
                else{
                    currentsum+=num;
                }
            }
            return true;
    }
}