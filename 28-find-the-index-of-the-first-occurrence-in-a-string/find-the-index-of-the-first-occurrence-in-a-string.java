class Solution {
    public int strStr(String haystack, String needle) {
        int n=haystack.length();
        int k=needle.length();
        for(int i=0;i<=n-k;i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                String subStr=haystack.substring(i,i+k);
                if(subStr.equals(needle)){
                    return i;
                }
            }
        }
      return -1;  
    }
}