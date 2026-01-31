class Solution {
    public String majorityFrequencyGroup(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int[] groupCount = new int[s.length() + 1];
        for (int f : freq) {
            if (f > 0) {
                groupCount[f]++;
            }
        }
        int maxGroupSize = 0;
        int bestFreq = 0;
       for (int f = 1; f < groupCount.length; f++) {
            if (groupCount[f] > maxGroupSize ||
               (groupCount[f] == maxGroupSize && f > bestFreq)) {
                maxGroupSize = groupCount[f];
                bestFreq = f;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (freq[i] == bestFreq) {
                result.append((char) ('a' + i));
            }
        }
        return result.toString();
    }
}
