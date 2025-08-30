class Solution {
    public boolean isAnagram(String s, String t) {
        String str1=s.replaceAll("\\s","");
        String str2=t.replaceAll("\\s","");
        if(str1.length()!=str2.length()){
            return false;
        }
        else{
            char c1[]=str1.toLowerCase().toCharArray();
            char c2[]=str2.toLowerCase().toCharArray();
            Arrays.sort(c1);
            Arrays.sort(c2);
            return Arrays.equals(c1,c2);
        }
        
    }
}