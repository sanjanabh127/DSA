class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        int cnt = 0, i = 0, j = 0;
        int ind1 = n / 2;
        int ind2 = ind1 - 1;
        int ind1el = -1, ind2el = -1;
        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) {
                if (cnt == ind1) ind1el = nums1[i];
                if (cnt == ind2) ind2el = nums1[i];
                i++;
            } else {
                if (cnt == ind1) ind1el = nums2[j];
                if (cnt == ind2) ind2el = nums2[j];
                j++;
            }
            cnt++;
        }

        while (i < n1) {
            if (cnt == ind1) ind1el = nums1[i];
            if (cnt == ind2) ind2el = nums1[i];
            i++;
            cnt++;
        }

        while (j < n2) {
            if (cnt == ind1) ind1el = nums2[j];
            if (cnt == ind2) ind2el = nums2[j];
            j++;
            cnt++;
        }

        if (n % 2 == 1) {
            return ind1el;
        }

        return (ind1el + ind2el) / 2.0;
    }
}
