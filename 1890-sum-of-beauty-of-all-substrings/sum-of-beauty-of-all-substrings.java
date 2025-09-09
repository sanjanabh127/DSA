class Solution {
    private int getMinCount(int[] freq) {
    int mini = Integer.MAX_VALUE;
    for (int i = 0; i < 26; i++) {
        if (freq[i] > 0) { 
            mini = Math.min(mini, freq[i]); 
        }
    }
    return mini == Integer.MAX_VALUE ? 0 : mini; 
}

    private int getMaxCount(int[] freq) {
        int maxi = 0;
        for (int i = 0; i < 26; i++) {
            maxi = Math.max(maxi, freq[i]);
        }
        return maxi;
    }

    public int beautySum(String s) {
        int n = s.length();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26]; 
            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++; 
                int beauty = getMaxCount(freq) - getMinCount(freq);
                sum += beauty;
            }
        }

        return sum;
    }
}
