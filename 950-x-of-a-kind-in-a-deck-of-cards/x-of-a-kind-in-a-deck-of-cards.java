class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] freq = new int[10000];
        for (int card : deck) {
            freq[card]++;
        }
        int gcd = 0;
        for (int count : freq) {
            if (count > 0) {
                gcd = gcd == 0 ? count : gcd(gcd, count);
            }
        }

        return gcd > 1;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
