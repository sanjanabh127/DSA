class Solution {
    public boolean isIsomorphic(String s, String t) {
       int[] hash =new int[256];
       boolean[] isMapped=new boolean[256];
       int n=s.length();
       for(int i=0;i<n;i++){
        if((hash[s.charAt(i)])==0&& (isMapped[t.charAt(i)])==false){
            hash[s.charAt(i)]=t.charAt(i);
            isMapped[t.charAt(i)]=true;
        }
       }
       for(int i=0;i<n;i++){
        if(((char)hash[s.charAt(i)])!=(t.charAt(i))){
            return false;
        }
       }
       return true;
    }
}