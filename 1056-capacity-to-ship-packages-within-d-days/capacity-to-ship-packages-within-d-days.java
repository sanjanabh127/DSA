class Solution {
    private int Dday(int[] weight,int capacity){
        int day=1;int load=0;
        int n=weight.length;
        for(int i=0;i<n;i++){
            if(load+weight[i]>capacity){
                day++;
                load=weight[i];
            }
            else{
                load+=weight[i];
            }
        }
        return day;
    }
    private int maxxi(int[] weights){
         int a=0;
         int n=weights.length;
        for(int i=0;i<n;i++){
            a=Math.max(a,weights[i]);
        }
        return a;
    }
    public int shipWithinDays(int[] weights, int days) {
       int low=maxxi(weights);
       int n=weights.length;
       int sum=0;
       for(int i=0;i<n;i++){
        sum=sum+weights[i];
       }
       int high =sum;
       while(low<=high){
        int mid=(low+high)/2;
        int nod=Dday(weights,mid);
        if(nod<=days){
            high=mid-1;
        }
        else{
            low=mid+1;
        }
       }
       return low;
    }
}