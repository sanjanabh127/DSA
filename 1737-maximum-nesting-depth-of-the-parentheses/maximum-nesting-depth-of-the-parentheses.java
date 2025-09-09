class Solution {
    public int maxDepth(String s) {
        int n=s.length();
        int res=0;
        int cnt=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                cnt++;
                res=Math.max(res,cnt);
            }
            if(s.charAt(i)==')'){
                cnt--;
            }
        }
        return res;
        
    }
}