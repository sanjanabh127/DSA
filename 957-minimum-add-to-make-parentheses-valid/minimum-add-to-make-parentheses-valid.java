class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0, close = 0;
        int n=s.length();
        for (int i=0;i<n;i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                } else {
                    close++; 
                }
            }
        }
        return open + close;
    }
}
