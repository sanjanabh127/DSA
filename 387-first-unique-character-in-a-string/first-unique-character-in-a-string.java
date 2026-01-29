class Solution {
    public int firstUniqChar(String s) {
        int[] chr=new int[26];
        for(char c:s.toCharArray()){
            chr[c-'a']++;
        }
        for(int i=0;i<s.length();i++){
            if(chr[s.charAt(i)-'a']==1){
                return i;
            }
        }
        return -1;   
    }
}