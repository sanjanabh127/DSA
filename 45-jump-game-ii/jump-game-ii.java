class Solution {
    public int jump(int[] nums) {
        int jumps=0;
        int l=0,r=0;
        int n=nums.length;
        while(r<n-1){
            int far=0;
            for(int ind=l;ind<=r;ind++){
                far=Math.max(ind+nums[ind],far);
            }
            l=r+1;
            r=far;
            jumps=jumps+1;
        }
        return jumps ;
    }
}