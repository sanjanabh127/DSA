class Solution {
    public int hammingWeight(int n) {
        int count=0;
        String s=Integer.toBinaryString(n);
        for(int i=0;i<s.length();i++){
        if(s.charAt(i)=='1'){
            count++;
        }
    }
    return count;
        
    }
}