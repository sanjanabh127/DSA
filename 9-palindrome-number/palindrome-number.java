class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        long rev = 0;
        int original = x;

        while (x != 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }

        return original == rev;
    }
}
