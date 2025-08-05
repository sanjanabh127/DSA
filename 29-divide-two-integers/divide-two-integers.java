class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        boolean sign = true;
        if (dividend <= 0 && divisor > 0) sign = false;
        else if (dividend >= 0 && divisor < 0) sign = false;

        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        long quotient = 0;

        while (n >= d) {
            int count = 0;
            while (n >= (d << (count + 1))) {
                count++;
            }
            quotient += 1L << count;
            n -= d << count;
        }

        return sign ? (int) quotient : -(int) quotient;
    }
}
