class Solution {
    private void func(int sum,int last,List<Integer> nums,int k,
    List<List<Integer>> ans){
        if(sum==0 && nums.size()==k){
            ans.add(new ArrayList<>(nums));
            return;
        }
        if(sum<=0 || nums.size()>k)return;
        for(int i=last;i<=9;i++){
            if(i<=sum){
                nums.add(i);
                func(sum-i,i+1,nums,k,ans);
                nums.remove(nums.size()-1);
            }
            else{
                break;
            }
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> nums=new ArrayList<>();
        func(n,1,nums,k,ans);
        return ans;
        
    }
}