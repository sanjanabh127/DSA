class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26]; 
        int l = 0, r = 0;
        int maxFreq = 0, maxLen = 0;

        while (r < s.length()) {
            count[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, count[s.charAt(r) - 'A']);
            while ((r - l + 1) - maxFreq > k) {
                count[s.charAt(l) - 'A']--;
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }

        return maxLen;
    }
}
