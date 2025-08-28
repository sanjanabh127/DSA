class Solution {
    public String reverseWords(String s) {
        String a[] = s.trim().split("\\s+"); 
        StringBuilder str1 = new StringBuilder();
        
        for (int i = a.length - 1; i >= 0; i--) {
            str1.append(a[i]).append(" ");
        }
        
        return str1.toString().trim(); 
    }
}
