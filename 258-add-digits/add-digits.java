class Solution {
    private int summ(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public int addDigits(int num) {
        while (num >= 10) {
            num = summ(num);
        }
        return num;
    }
}
