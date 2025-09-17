class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";

        int[] hash = new int[256];
        for (int i = 0; i < t.length(); i++) {
            hash[t.charAt(i)]++;
        }

        int left = 0, right = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;
        while (right < s.length()) {
            if (hash[s.charAt(right)] > 0) {
                count++;
            }
            hash[s.charAt(right)]--;
            right++;
            while (count == t.length()) {
                if (right - left < minLen) {
                    minLen = right - left;
                    startIndex = left;
                }
                hash[s.charAt(left)]++;
                if (hash[s.charAt(left)] > 0) {
                    count--;
                }
                left++;
            }
        }

        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLen);
    }
}
