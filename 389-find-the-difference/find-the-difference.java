class Solution {
    public char findTheDifference(String s, String t) {
     char result =0;
     for(char c:s.toCharArray()){
        result^=c;
     }
     for(char d:t.toCharArray()){
        result^=d;
     }
     return result;
    }
}