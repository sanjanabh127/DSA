class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer>list=new ArrayList<>();
        int n=nums.length;
        int x=0,k=0;
        for(int i=0;i<n;i++){
            if(nums[i]<target)x++;
            if(nums[i]==target)k++;
        }
        while(k-->0){
            list.add(x);
            x++;
        }
        return list;
    }
}
