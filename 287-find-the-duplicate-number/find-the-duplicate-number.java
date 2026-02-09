class Solution {
    public int findDuplicate(int[] nums) {
        int left=0,right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            int count=0;
            for(int num:nums){
                if(num<=mid)count++;
            }
            if(count>mid){
                right=mid;
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }
}