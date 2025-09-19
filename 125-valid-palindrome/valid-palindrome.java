
   class Solution {
    public boolean isPalindrome(String s) {
        return check(s, 0, s.length() - 1);
    }

    private boolean check(String s, int i, int j) {
        while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
        while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
        if (i >= j) return true;
        if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
        return check(s, i + 1, j - 1);
    }
}
