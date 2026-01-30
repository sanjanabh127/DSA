class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] arr=new int[100];
        int n=0;
        for(int i=0;i<dominoes.length;i++){
             int a=dominoes[i][0];
             int b=dominoes[i][1];
             int x=Math.min(a,b);
             int y=Math.max(a,b);
             int key=x*10+y;
             n+=arr[key];
             arr[key]++;
        }
      
       return n; 
    }
}