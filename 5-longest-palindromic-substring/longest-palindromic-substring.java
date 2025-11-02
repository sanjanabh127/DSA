class Solution {
    private static boolean CheckPal(String pal,int low,int high){
        while(low<high){
            if(pal.charAt(low)!=pal.charAt(high)){
                return false;
            }
                low++;
                high--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int n=s.length();
        int maxLen=1,start=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(CheckPal(s,i,j)&&(j-i+1)>maxLen){
                    start=i;
                    maxLen=j-i+1;
                }

            }
        }
        return s.substring(start,start+maxLen);
    }
}