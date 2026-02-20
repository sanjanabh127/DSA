class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0, sumB = 0;
        for (int a : aliceSizes) sumA += a;
        for (int b : bobSizes) sumB += b;
        int diff = (sumA - sumB) / 2;
        Set<Integer> setB = new HashSet<>();
        for (int b : bobSizes)
            setB.add(b);
        for (int x : aliceSizes) {
            int y = x - diff;
            if (setB.contains(y)) {
                return new int[]{x, y};
            }
        }

        return new int[0];
    }
}